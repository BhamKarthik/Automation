package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {
	public static Map<String,String> fileAndEnv =new HashMap<String,String>();
	public static Properties propMain =new Properties();
	public static Properties propPreSet =new Properties();

	public static Map<String,String> envAndFile()
	{
		String environment=System.getProperty("env");
		 environment="staging";

		try {
			if(environment.equalsIgnoreCase("staging")) 
			{
				FileInputStream fisstage=new FileInputStream(System.getProperty("user.dir")+"/inputs/staging.properties");
				propMain.load(fisstage);
				fileAndEnv.put("ServerURL", propMain.getProperty("ServerURL"));
			}
		}
		catch(Exception ex) {}
		return fileAndEnv;

	}
	public static Map<String,String> getCongigReader()
	{
		if (fileAndEnv==null) {
			fileAndEnv=envAndFile();
		}
		return fileAndEnv;

	}



}
