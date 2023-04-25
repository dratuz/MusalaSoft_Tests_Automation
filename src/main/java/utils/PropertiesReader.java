package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static String getBrowser(String filePath) throws IOException {
        Properties properties = getProperties(filePath);

        // Retrieve the value of the "email" property
        return properties.getProperty("browser");
    }
    public static String getUrl(String filePath) throws IOException {
        Properties properties = getProperties(filePath);

        // Retrieve the value of the "email" property
        return properties.getProperty("baseUrl");
    }
    public static String invalidEmail(String filePath) throws IOException {
        Properties properties = getProperties(filePath);

        // Retrieve the value of the "email" property
        return properties.getProperty("testEmail");
    }

    public static String cvPath(String filePath) throws IOException {
        Properties properties = getProperties(filePath);

        // Retrieve the value of the "email" property
        return properties.getProperty("cvPath");
    }

    private static Properties getProperties(String filePath) throws IOException {
        Properties properties = new Properties();

        FileInputStream fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
        return properties;
    }
}
