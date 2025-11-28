package GenericLibraryOrUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer {
	int count =1;
	int retryCount =3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		while(count<=retryCount) {
			count++;
			return true;
		}
		return false;
	}
	
}
