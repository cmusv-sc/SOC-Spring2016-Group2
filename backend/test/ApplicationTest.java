import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertThat(a, equalTo(2));
    }
}
