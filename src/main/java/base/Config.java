package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

import java.util.Properties;

public class Config {

        public Properties prop = new Properties();
        InputStream input = null;

        private static final Logger log = LogManager.getLogger(Config.class.getName());

        public String getProperties(String key) {

                try {
                        input =  getClass().getClassLoader().getResourceAsStream("base.properties");
                        prop.load(input);
                        if(input == null) {
                                log.error("Properties file not found");
                        }

                } catch(IOException e) {
                        e.printStackTrace();
                        log.error("Exception found: " + e);
                }
                return prop.getProperty(key);
        }

}
