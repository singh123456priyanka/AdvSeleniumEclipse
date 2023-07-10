package Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * To avoid repetition in code
	 * @param Key
	 * @return value
	 * @throws IOException
	 * @author Priyanka
	 */
	
	public String getStringKeyandValue(String Key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/vtigerCredential.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(Key);			
		return value;
		
	}

}
