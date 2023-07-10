package Generic_Utility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	/**
	 * This method is used to avoid duplicates
	 * @return int
	 * @author Priyanka
	 */
	
	public int getRandomNum()
	{
		Random ran= new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
	/**
	 * This method gives System date and time
	 * @void method
	 * @author Priyanka
	 */
	public void getSysDate()
	{
		Date date=new Date();
		System.out.println(date);
		String d = date.toString().replace(" ","-").replace(":", " ");
		System.out.println(d);
	}
	/**
	 * This method gives local date and time
	 * @void method
	 * @author Priyanka
	 */
	
	public void getLocDate()
	{
		LocalDateTime local = LocalDateTime.now();
		System.out.println(local);
		String d = local.toString().replace(" ","-").replace(":", " ");
		System.out.println(d);
	}
	
	

}
