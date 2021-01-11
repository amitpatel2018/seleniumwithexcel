package utilities;

// import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListeners extends TestListenerAdapter {
	public void onTestFailure(ITestResult result) {
		if(ITestResult.FAILURE == result.getStatus()) {
			Base.takeScreenshotForFailedTest(result.getMethod().getMethodName());
		}
	}
//	public void onFinish(ITestContext arg0) {}				
//    public void onStart(ITestContext arg0) {}				
//    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}			
//    public void onTestSkipped(ITestResult arg0) {}			
//    public void onTestStart(ITestResult arg0) {}				
//    public void onTestSuccess(ITestResult arg0) {}		
}		
