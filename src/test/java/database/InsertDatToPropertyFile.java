package database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class InsertDatToPropertyFile {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		prop.setProperty("browser", "chrome");
		prop.setProperty("url","http://localhost:8888");
		prop.setProperty("username","admin");
		prop.setProperty("password","admin");

		//just neeche wala method is working for path same Advan sel folder me create kar raha h
		FileOutputStream fout = new FileOutputStream(System.getProperty("user.dir")+".\\src\\test\\resources\\commondata.properties.txt");
		prop.store(fout,"Common Data");
		fout.close();

		//ye wala bahar desktop me ek folder banaya h checkingData usme save kar raha hai
		//also "user.dir" nai lena h or else error ayega.
		//fout aur fout2 ko execute karne se fout2 me notepad ban to raha h but without data
		FileOutputStream fout2 = new FileOutputStream("C:\\Users\\panka\\OneDrive\\Desktop\\checkingData\\data.properties.txt");
		prop.store(fout2,"Common Data @By Priyanka");

		fout2.close();
		
		
		
		
	}

}
