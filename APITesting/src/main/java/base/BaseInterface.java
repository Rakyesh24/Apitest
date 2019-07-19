package base;

import org.openqa.selenium.WebElement;

public interface BaseInterface {

	
	abstract void openBrowser(String browser);
	abstract void getUrl(String appurl);
	abstract WebElement getElement(String locator);
	abstract boolean isElementPresent(String locator);
	abstract void clickButton(String locator);
	abstract String getElementText(String locator);
	abstract void typeText(String locator,String key);
	abstract String getTime();
	abstract void getScreenShot();
	abstract void getReport();
	abstract void waitToLoad();
	abstract Object[][] getData(String file,int index);
	abstract void selectElement(int index,String locator);
	abstract void selectElement(String str,String locator);
	abstract void sendkeyAction(String str,String locator);
	abstract void rightClick(String locator);
	abstract void dragdropAction(String locator,int x,int y);
	abstract void scroll(int x,int y);
	abstract void scroll(String locator);
	abstract void scrollUp();
	abstract void scrollDown();
	abstract String gettextAlert();
	abstract void acceptAlert();
	abstract void dismissAlert();
	abstract void closeWindow();
	abstract void switchFrame(int index);
	abstract void switchFrame(String locator);
	
}
