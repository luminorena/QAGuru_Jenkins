package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    @Tag("systemPropertiesTest")
    void systemPropertyTest(){
        System.getProperty("browser", "firefox");
        System.getProperty("browser_version", "105");
        System.getProperty("browser_size", "1920x1080");
        System.getProperty("remote_url"
                , "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }
}
