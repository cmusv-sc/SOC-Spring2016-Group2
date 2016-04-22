package basicTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import play.test.FakeApplication;
import play.test.Helpers;

@SuppressWarnings("deprecation")
public class BasicTest {
	  public static FakeApplication app;

	  @BeforeClass
	  public static void startApp() {
	    app = (FakeApplication) Helpers.fakeApplication(Helpers.inMemoryDatabase());
	    Helpers.start(app);
	  }

	  @AfterClass
	  public static void stopApp() {
	    Helpers.stop(app);
	  }
}
