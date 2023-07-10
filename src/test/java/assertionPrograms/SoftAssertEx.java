package assertionPrograms;

import org.testng.asserts.SoftAssert;

public class SoftAssertEx {

	public static void main(String[] args) {
		
			System.out.println("Step 1");
			String actvalue="Priyanka";
			String expvalue="Priyanka";
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actvalue, expvalue);
			System.out.println("step 2");
			System.out.println("step 3");
			m2();// step4 step5 shows but not fail for that there also written assertall
			soft.assertAll();//it can tell pass and fail abt main method but not for m2()
	
	}
	
	public static void m2() {
		SoftAssert soft = new SoftAssert();
		System.out.println("step4"); 
		soft.assertEquals(true, false);
		System.out.println("step5");
		soft.assertAll();//only after writing here also it is telling fail here
	}


}
