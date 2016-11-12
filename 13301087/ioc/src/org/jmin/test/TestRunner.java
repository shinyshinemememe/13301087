package org.jmin.test;

/**
 * 测试运行
 * 
 * @author Chris liao
 */
public class TestRunner {

	/**
	 * 运行某个类的测试
	 */
	public static void run(Class testClass)throws Throwable{
		if (testClass != null) {
			((TestCase)testClass.newInstance()).run();
		}
	}
	
	/**
	 * 运行一批测试类
	 */
	public static void run(Class[] testClass)throws Throwable{
		if(testClass!=null){
			for(int i=0;i<testClass.length;i++)
			 run(testClass[i]);
		}
	}
	
	public static void main(String[] arg){
	System.out.println(String.class.isAssignableFrom(String.class));
		
		
		//String methodName ="setD";
		
	  //System.out.println(methodName.substring(3,4).toLowerCase()+ (methodName.length()>3?methodName.substring(4):""));
	}
	
}
