package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    protected static String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = determineBaseUrl();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    private String determineBaseUrl() {
        String environment = System.getProperty("env", "test");
        String configFileName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found" + configFileName);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Configuration file not found" + configFileName, e);
        }
        return properties.getProperty("baseUrl");
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }

}