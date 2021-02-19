package base;

public class BaseTest {

    public void setup() {
        Capabilities.getInstance().setCapabilities();
    }

    public void teardown() {
        Capabilities.getInstance().closeDriver();
    }

}
