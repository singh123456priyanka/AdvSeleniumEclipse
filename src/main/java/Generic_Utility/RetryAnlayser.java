package Generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnlayser implements IRetryAnalyzer{
int count=0;
int retrylimit=2;

@Override
public boolean retry(ITestResult result) {
	if(count<retrylimit) {
		count++;
		return true;
	}
	return false;
}
//genericCreatingCampaign me assert dala false fir 
//assert k wajah se 1 failure aur 2 retries aya so total run will be 3
}
