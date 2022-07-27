package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Sample {

	
	@Test
	public void test1() {
		System.out.println("Test1");
	}
	
	@Test(dependsOnMethods = {"test3"})
	public void test2() {
		System.out.println("Test2");
	}
	
	@Test(timeOut = 2000)
	public void test3() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Test3");
	}
	
	
}
