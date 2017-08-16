package W13ZhilinComQALightOldByAnnotation.ComQALightOld;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class Test4 extends Parent{
	public Zapisatsya zapisatsya;

	public Test4(String browser) throws MalformedURLException {
		super(browser);
	}

	@Ignore
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
		Assert.assertTrue(zapisatsya.isMessageSendOkPresent());
	}
	
	@After
	public void tearDown(){
		zapisatsya.close();
	}
}
