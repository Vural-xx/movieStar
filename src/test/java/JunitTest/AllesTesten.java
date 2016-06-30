package JunitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BenutzerControllerTest.class, BenutzerDAOTest.class, FilmControllerTest.class, FilmDAOTest.class })
public class AllesTesten {

}
