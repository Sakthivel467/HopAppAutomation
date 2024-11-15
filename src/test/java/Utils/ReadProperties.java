package Utils;

import extentReport.Constants;
import org.apache.commons.lang3.StringUtils;
import java.io.FileInputStream;
import java.util.Properties;

import static org.apache.commons.codec.binary.StringUtils.*;

public class ReadProperties {
	
	static Properties prop = new Properties();
	
	public static String getData(String key) throws Exception
	{
		String filepath = Constants.PROPERTY_FILE_PATH;
		
		FileInputStream fis = new FileInputStream(filepath);
		prop.load(fis);
		String value = prop.getProperty(key);
		if(StringUtils.isEmpty(value)) {
			throw new Exception("Value not specified in key:" +key+ "in properties file");
		}
		return value;
	}

}
