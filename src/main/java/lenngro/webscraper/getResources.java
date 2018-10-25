package lenngro.webscraper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class getResources {

    public String[] getPropValues() throws IOException {

        String propsArr[] = new String[3];
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);


        try {

            Properties prop = new Properties();

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            String urlToScrape = prop.getProperty("urlToScrape");
            String logFilePath = prop.getProperty("logFilePath");
            String downloadFolderPath = prop.getProperty("downloadFolderPath");
            propsArr[0] = urlToScrape;
            propsArr[1] = logFilePath;
            propsArr[2] = downloadFolderPath;

            return propsArr;

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return propsArr;
    }


}