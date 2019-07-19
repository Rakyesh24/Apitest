package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class TestAbstract implements BaseInterface {

	public WebDriver driver = null;
	public Properties prop = null;
	public WebElement ele = null;
	public ExtentHtmlReporter reporter = null;
	public ExtentReports extent = null;
	public ExtentTest logger = null;
	public JavascriptExecutor js = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public Select sel = null;
	public Actions act = null;

	TestAbstract() {
		prop = new Properties();
		String file = "./src/main/resources/data/OR.properties";
		try {
			FileInputStream srcfile = new FileInputStream(file);
			try {
				prop.load(srcfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
