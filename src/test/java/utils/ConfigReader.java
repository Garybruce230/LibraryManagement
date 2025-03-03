package utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    Properties properties = new Properties();

    public ConfigReader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("DataConfig/config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            properties.load(input);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getWebsiteURL() {
        return properties.getProperty("websiteURL");
    }
}
