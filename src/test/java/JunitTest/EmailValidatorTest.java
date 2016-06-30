package JunitTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.BenutzerController;
import model.Benutzer;
import validators.EmailValidator;

public class EmailValidatorTest {

	private EmailValidator emVal;
	
	
	@Before
	public void initialisieren(){
		emVal = new EmailValidator();
	}	
	
	@Test
	public void validateTest() {
		Assert.assertTrue(emVal.validate("Walter@web.de"));
	}
	
	@Test
	public void validateTest2() {
		Assert.assertTrue(emVal.validate("WalterMeyerNiederkrome@web.de"));
	}
	
	@Test
	public void validateTest3() {
		Assert.assertTrue(emVal.validate("W@web.de"));
	}
	
	@Test
	public void validateTest4() {
		Assert.assertTrue(emVal.validate("Arschloch@web.de"));
	}
	
	@Test
	public void validateTest5() {
		Assert.assertTrue(emVal.validate("Walter@googlemail.hsbremen.de"));
	}

	@Test
	public void validateTest6() {
		Assert.assertFalse(emVal.validate("Walter"));
	}
	
	@Test
	public void validateTest7() {
		Assert.assertFalse(emVal.validate("Walter.Meyer"));
	}
	
	@Test
	public void validateTest8() {
		Assert.assertFalse(emVal.validate("..,Walter@web.de"));
	}
	
	@Test
	public void validateTest9() {
		Assert.assertFalse(emVal.validate("@ter@web.de"));
	}
	
	@Test
	public void validateTest10() {
		Assert.assertFalse(emVal.validate("6797@web.de.de.de.de-,P"));
	}
}
