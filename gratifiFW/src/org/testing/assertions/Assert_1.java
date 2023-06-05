package org.testing.assertions;

public class Assert_1 
{

	public static void assertion(String expectedResult, String actualResult)
	{
		if(expectedResult.equals(actualResult))
		{
			System.out.println("Assertion is passed");
		}
		else
		{
			System.out.println("Assertion is failed");
		}
	}
}
