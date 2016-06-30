package JunitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BenutzerControllerTest.class, BenutzerDAOTest.class, EmailValidatorTest.class, FilmControllerTest.class,
		FilmDAOTest.class, PasswortValidatorTest.class })
public class AllTests {

}
