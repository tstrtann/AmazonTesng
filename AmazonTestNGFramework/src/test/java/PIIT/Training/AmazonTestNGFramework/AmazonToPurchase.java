package PIIT.Training.AmazonTestNGFramework;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.dockerjava.api.model.Driver;

import Amazon.Home;
import Amazon.Product;
import Amazon.Results;
import Common.Common;

public class AmazonToPurchase extends Common{
  @Test
  public void homepageSearch() throws InterruptedException {
	  Home home = new Home(driver);
	  home.searchFieldSendKeys("computer");
	  home.searchBtnClick();
	  
	  Results results = new Results(driver);
	  int testResults = results.resultsToVerify();
	  System.out.println(testResults);
	  
	  if(testResults==1) {
		  System.out.println("Result is existing for computer search");
	  } else {
		System.out.println("Result is not found");
	  }
	  
	  SoftAssert sa = new SoftAssert();
	  sa.assertEquals(1, testResults);
	  
	  results.computerToClick();
	  
	  Product product = new Product(driver);
	  product.addToCartClick();
	  Thread.sleep(5000);
	  product.noThanksClick();
	  Thread.sleep(15000);
	  product.addToCartClick();
	  
	  sa.assertAll();

  }
}
