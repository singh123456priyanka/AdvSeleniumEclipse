package others;

import org.testng.annotations.Test;


public class TestNgEx {
	@Test(priority=0)
	public void helloWorld () {
		System.out.println("Hello World");
	}
	@Test(priority=-1)
	public void helloEarth() {
		System.out.println("Hello Earth");
	}
	@Test(enabled=false)
	public void hellohuman()
	{
		System.out.println("Hello human");
	}
}
