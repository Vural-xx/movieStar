package JunitTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import validators.EmailValidator;
import validators.PasswordValidator;

public class PasswortValidatorTest {
		
	private PasswordValidator pasVal;
		
		
		@Before
		public void initialisieren(){
			pasVal = new PasswordValidator();
		}	
		
		@Test
		public void validateTest() {
			Assert.assertFalse(pasVal.validate("Walter@web.de"));	
		}
		
		@Test
		public void validateTest2() {
			Assert.assertFalse(pasVal.validate("Test"));	
		}
		
		@Test
		public void validateTest3() {
			Assert.assertFalse(pasVal.validate("123456"));	
		}
		
		@Test
		public void validateTest4() {
			Assert.assertFalse(pasVal.validate("Walter.de"));	
		}
		
		@Test
		public void validateTest5() {
			Assert.assertFalse(pasVal.validate("Test.123"));	
		}
		
		@Test
		public void validateTest6() {
			Assert.assertFalse(pasVal.validate("te/2"));	
		}
		
		@Test
		public void validateTest7() {
			Assert.assertTrue(pasVal.validate("Test-123"));	
		}
		
		@Test
		public void validateTest8() {
			Assert.assertTrue(pasVal.validate("Passwort4.0-2"));	
		}
		
		@Test
		public void validateTest9() {
			Assert.assertTrue(pasVal.validate("MeineOma - & Jau12"));	
		}
		
		//akjsbd
		
		
		@Test
		public void validateTest10() {
			Assert.assertTrue(pasVal.validate("123&Hallo"));	
		}
		
		@Test
		public void validateTest11() {
			Assert.assertTrue(pasVal.validate("alsPasswort-&Jan72"));	
		}
		
		@Test
		public void validateTest12() {
			Assert.assertFalse(pasVal.validate("lksada-&123njkaslcuuassd"));	
		}
}
