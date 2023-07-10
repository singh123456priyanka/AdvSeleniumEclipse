package Generic_Utility;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentReportImp implements ITestListener{
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	//1.
		@Override
		public void onStart(ITestContext context) {
			//Step 1-Extent Report Configuration
			Date d=new Date();
			System.out.println(d);
			d.toString().replace(":", "-").replace(" ", "*");
			
			ExtentSparkReporter htmlReport = new ExtentSparkReporter(new File("ExtentReport.html"));
			htmlReport.config().setDocumentTitle("Vtiger ExtentReport");
			htmlReport.config().setTheme(Theme.STANDARD);
			htmlReport.config().setReportName("Automation test");
			
			//step2
			//Attach the physical report and do the system configuration
			report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("OS: ","Windows 11");
			report.setSystemInfo("Enviornment: ", "Automation Testing");
			report.setSystemInfo("URL: ","http://localhost:8888/");
			report.setSystemInfo("Reporter Name: ","Priyanka");		
			
		}


	@Override
	public void onTestStart(ITestResult result) {
		//step 3: Create test methods during the test execution starts.
		report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//step4: Log the pass method
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//step5: Log the fail method
		String testData=result.getMethod().getMethodName();
		System.out.println("-----execute-----");
		EventFiringWebDriver efdriver = new EventFiringWebDriver(BaseClass.Sdriver);
		File src = efdriver.getScreenshotAs(OutputType.FILE);		
		try {
			Files.copy(src,new File("./screenshotAdv/"+testData+".png"));
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		
		Java_Utility jlib = new Java_Utility();
		System.out.println("Local time: ");
		jlib.getLocDate();
		System.out.println("\nSystem time: ");
		jlib.getSysDate();


	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//step6: Log the skip method
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
			}

}
