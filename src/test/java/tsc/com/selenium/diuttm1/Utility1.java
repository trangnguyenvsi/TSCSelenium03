package tsc.com.selenium.diuttm1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility1 {
		public static Properties readConfig() throws IOException {
		// Create new properties variable
		Properties p = new Properties();
		// Read object properties file
		InputStream stream = new FileInputStream("C:\\Users\\diuttm\\workspace\\Day3\\config.properties");
		// Load input stream file
		p.load(stream);
		return p;
		}
}
