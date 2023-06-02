package testingComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMechanism implements IRetryAnalyzer {

    int maxTries = 2;
    int count =0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count<maxTries){
            count++;
            return true;    // whenever this function returns true, the failed test will be retried
        }
        return false;
    }
}
