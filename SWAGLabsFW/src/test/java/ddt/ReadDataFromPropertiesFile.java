package ddt;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// Read data from Proerties File
		// 1. Create the object of Java representation file
		FileInputStream fis = new FileInputStream("./src/main/resources/commondata.properties");

		// 2. Create the object of Properties file
		Properties pobj = new Properties();

		// 3. Load all the keys
		pobj.load(fis);

		// 4. Read the data
		String browser = pobj.getProperty("browser");
		String url = pobj.getProperty("url");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");

		System.out.println("Browser --> "+browser);
		System.out.println("URL --> "+url);
		System.out.println("Username --> "+username);
		System.out.println("Password --> "+password);
	}

}
