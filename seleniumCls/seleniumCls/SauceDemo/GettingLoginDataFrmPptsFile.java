package SauceDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GettingLoginDataFrmPptsFile {
	
	Properties pro = new Properties();
	
	public GettingLoginDataFrmPptsFile(String path)
	{
		FileInputStream file;
		try {
			file = new FileInputStream(path);
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
	
	public String getUrl()
	{
		String url= pro.getProperty("baseurl");
		return url;
	}
	
	public String getUsername()
	{
		String uname=pro.getProperty("uname1");
		return uname;
	}
	
	public String getPwd()
	{
		String pwd=pro.getProperty("pwd");
		return pwd;
	}

}
