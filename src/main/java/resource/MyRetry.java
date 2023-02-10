package resource;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer{

	int counter = 0;
	int maxRetry =3;
	
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(counter<maxRetry) {
			counter++;
			return true;
		}
		return false;
	}

}
