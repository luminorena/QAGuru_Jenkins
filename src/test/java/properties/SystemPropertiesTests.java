package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("systemPropertiesTest")
    void systemPropertyTest(){
        System.getProperty("browser", "firefox");
        System.getProperty("browserVersion", "105");
        System.getProperty("windowSize", "1920x1080");
        System.getProperty("remoteURL"
                , "https://user1:1234@selenoid.autotests.cloud/wd/hub");

    }
}
