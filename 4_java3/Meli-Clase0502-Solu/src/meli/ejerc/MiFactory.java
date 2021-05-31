package meli.ejerc;

import java.io.FileInputStream;
import java.util.Properties;

public class MiFactory
{
	public static Object getInstance(String objName)
	{
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream("MiFactory.properties");
			Properties p = new Properties();
			p.load(fis);
			String className = p.getProperty(objName);
			
			return Class.forName(className).newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			
		}
	}
}
