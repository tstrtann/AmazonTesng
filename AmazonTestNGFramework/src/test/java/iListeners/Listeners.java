package iListeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Amazon.Results;
import Common.Common;

public class Listeners extends Common implements ITestListener{

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver = ((Common)result.getInstance()).driver;
		try {
			Screenshots("onTestSuccess");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver = ((Common)result.getInstance()).driver;
		try {
			Screenshots("onTestFailure");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		this.driver = ((Common)result.getInstance()).driver;
		try {
			Screenshots("snapshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
