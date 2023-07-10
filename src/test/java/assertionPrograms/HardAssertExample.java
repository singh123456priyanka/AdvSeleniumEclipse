package assertionPrograms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {
	@Test
	public void m1() {
		System.out.println("Step 1");
		String actvalue="Priyanka";
		String expvalue="priyanka";
		Assert.assertEquals(actvalue, expvalue);
		System.out.println("step 2");
		System.out.println("step 3");
	}
	
	@Test
	public void m2() {
		System.out.println("step4"); 
		Assert.assertEquals(true, true);
		System.out.println("step5");
	}

}
