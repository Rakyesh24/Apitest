package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase extends TestAbstract implements BaseInterface {

	@Override
	public void openBrowser(String browser) {
		if (driver == null)
			try {
				if (browser.equals("chrome")) {
					driver = new ChromeDriver();
				} else if (browser.equals("firefox")) {
					driver = new FirefoxDriver();
				} else if (browser.equals("edge")) {
					driver = new EdgeDriver();
				} else if (browser.equals("ie")) {
					driver = new InternetExplorerDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			}

			catch (Exception e) {
				// TODO: handle exception
			}

	}

	@Override
	public void getUrl(String appurl) {
		driver.get(prop.getProperty(appurl));

	}

	@Override
	public WebElement getElement(String locator) {
		WebElement e = null;
		try {
			if (locator.endsWith("_xpath")) {
				e = driver.findElement(By.xpath(prop.getProperty(locator)));
			} else if (locator.endsWith("_id")) {
				e = driver.findElement(By.id(prop.getProperty(locator)));
			} else if (locator.endsWith("_name")) {
				e = driver.findElement(By.name(prop.getProperty(locator)));
			} else if (locator.endsWith("_css")) {
				e = driver.findElement(By.cssSelector(prop.getProperty(locator)));
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
		return e;

	}

	@Override
	public boolean isElementPresent(String locator) {
		if (getElement(locator).isDisplayed())
			return true;
		else
			return false;
	}

	@Override
	public void clickButton(String locator) {
		getElement(locator).click();

	}

	@Override
	public String getElementText(String locator) {

		return getElement(locator).getText();
	}

	@Override
	public void typeText(String locator, String key) {
		getElement(locator).sendKeys(prop.getProperty(key));

	}

	@Override
	public String getTime() {
		Date current = new Date();
		String day = new SimpleDateFormat("dd").format(current);
		String month = new SimpleDateFormat("MMMM").format(current);
		String year = new SimpleDateFormat("yyyy").format(current);
		String hour = new SimpleDateFormat("hh").format(current);
		String min = new SimpleDateFormat("mm").format(current);
		String desiredDate = month + year + "/" + day + "/" + hour + min;
		return desiredDate;
	}

	@Override
	public void getScreenShot() {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(file, new File("./Screenshot/" + getTime() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getReport() {
		reporter = new ExtentHtmlReporter("./Reports/" + getTime() + ".html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		// logger=extent.createTest("Your test name");
		// logger=logger.log(Status.INFO, "Write message");

	}

	@Override
	public void waitToLoad() {

		js = (JavascriptExecutor) driver;

		while (true) {
			String status = (String) js.executeScript("return document.readyState");
			if (!status.equals("complete")) {
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (status.equals("complete")) {
				break;
			}

		}

	}

	@Override
	public Object[][] getData(String file, int index) {

		try {
			workbook = new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheetAt(index);
		int rowNum = sheet.getLastRowNum();

		Object[][] obj = new Object[rowNum][1];

		for (int i = 0; i < rowNum; i++) {
			Hashtable<String, String> data = new Hashtable<String, String>();
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i + 1).getCell(j).getStringCellValue();
				data.put(key, value);
			}
			obj[i][0] = data;
		}

		return obj;
	}

	@Override
	public void selectElement(int index, String locator) {

		sel = new Select(getElement(locator));
		sel.selectByIndex(index);

	}

	@Override
	public void selectElement(String str, String locator) {
		sel = new Select(getElement(locator));
		sel.selectByValue(str);

	}

	@Override
	public void sendkeyAction(String str, String locator) {

		act = new Actions(driver);
		act.sendKeys(getElement(locator), str).build().perform();

	}

	@Override
	public void rightClick(String locator) {

		act = new Actions(driver);
		act.contextClick(getElement(locator)).build().perform();

	}

	@Override
	public void dragdropAction(String locator, int x, int y) {
		act = new Actions(driver);
		act.dragAndDropBy(getElement(locator), x, y);

	}

	@Override
	public void scroll(int x, int y) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");

	}

	@Override
	public void scroll(String locator) {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.arguments[0].scrollTo(true)", getElement(locator));

	}

	@Override
	public void scrollUp() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

	}

	@Override
	public void scrollDown() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	@Override
	public String gettextAlert() {

		return driver.switchTo().alert().getText();
	}

	@Override
	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	@Override
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	@Override
	public void closeWindow() {

		String parent = driver.getWindowHandle();

		Set<String> allwin = driver.getWindowHandles();

		for (String str : allwin) {
			if (!str.equals(parent))
				driver.switchTo().window(str).close();

		}
		driver.switchTo().window(parent);

	}

	@Override
	public void switchFrame(int index) {
		driver.switchTo().frame(index);

	}

	@Override
	public void switchFrame(String locator) {
		driver.switchTo().frame(getElement(locator));

	}

}
