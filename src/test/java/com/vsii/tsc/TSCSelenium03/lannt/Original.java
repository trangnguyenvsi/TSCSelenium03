package com.vsii.tsc.TSCSelenium03.lannt;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Original {
	public static Properties readConfig() throws IOException {
		// Create new properties variable
		Properties p = new Properties();
		// Read object properties file
		InputStream stream = new FileInputStream("./properties111/config.properties");
		// Load input stream file
		p.load(stream);
		return p;
		}
}
