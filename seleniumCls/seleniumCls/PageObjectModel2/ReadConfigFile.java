//This file is to get data from properties file

package PageObjectModel2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigFile {
	
	Properties pro;
	
	public ReadConfigFile(String path)
	{
		FileInputStream file;
		try {
			file = new FileInputStream(path);
			pro = new Properties();
			pro.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String getTitle()
	{
		String title=pro.getProperty("title");
		return title;
	}
	
	public String getUsername()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String pwd= pro.getProperty("password");
		return pwd;
	}
	
	public String getForgottenPwdLink()
	{
		String forgottenpwdlink=pro.getProperty("forgottenpwdurl");
		return forgottenpwdlink;
	}

}
