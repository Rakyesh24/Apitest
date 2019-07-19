package testsuite1;

import org.testng.annotations.Test;



import base.TestBase;

public class Naukri extends TestBase {
	
	@Test
	public void name() {
		openBrowser("chrome");
		getUrl("naukri");
		closeWindow();
		scrollDown();
		
	}

}
