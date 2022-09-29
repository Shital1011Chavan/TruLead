package espl.LA.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider()
	{
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream file=new FileInputStream(src);
			
			prop=new Properties();
			
			prop.load(file);
		}
		
		catch (Exception e)
		{
			System.out.println("Not able to load config file >>"+e.getMessage());
		}
	}
	
	public String getDataFromConfig(String keyToSearch)
	{
		return prop.getProperty(keyToSearch);
		
	}
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	
	
	public String getStagingURL()
	{
		return prop.getProperty("QaUrl");
		
	}
	
	public String getAssTitle()
	{
		return prop.getProperty("AssessmentName");
		
	}
	public String getAssessmentAct()
	{
		return prop.getProperty("AssessmentAct");
		
	}
	public String get360Act()
	{
		return prop.getProperty("360Act");
		
	}
	public String getPsychometricAct()
	{
		return prop.getProperty("PsychometricAct");
		
	}
	public String getPremium360Act()
	{
		return prop.getProperty("Premium360Act");
		
	}
}

