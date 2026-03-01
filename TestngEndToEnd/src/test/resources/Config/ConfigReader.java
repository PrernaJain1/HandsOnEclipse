package Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public String getData(String data) throws IOException {
		Properties p = new Properties();
		FileInputStream f= new FileInputStream("C:\\Users\\91914\\eclipse-workspace\\TestngEndToEnd\\src\\test\\resources\\Config\\config.properties");
		p.load(f);
		
		String s= p.getProperty(data);
		return s;
	}
}
