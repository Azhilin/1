package W13ZhilinComQALightOldByAnnotation.ComQALightOld;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class Test3 extends Parent{
	public Zapisatsya zapisatsya;

	public Test3(String browser) throws MalformedURLException {
		super(browser);
	}

	@Test
	public void test(){
		zapisatsya = new Zapisatsya(driver);
		
		zapisatsya.openPage();
		zapisatsya.selectValueInDDKurs("PL/SQL");
		zapisatsya.inputTextIntoLastNameField("Zhilin");
		zapisatsya.inputTextIntoFirstNameField("Alex");
		zapisatsya.inputTextIntoPhoneField("0509113790");
		zapisatsya.inputTextIntoEmailField("alexei.zhilin@gmail.com");
		zapisatsya.submitButtonClick();
		Assert.assertTrue(zapisatsya.isMessageSendErrorPresent());
	}
	
	@After
	public void tearDown(){
		zapisatsya.close();
	}
}
