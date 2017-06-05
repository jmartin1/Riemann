package Riemann;
import polyfun.Polynomial;
import Riemann.PolyPractice;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: This tests the addxsquared method, which is part of the class PolyPractice. 
 */

public class AddXSquardTest {
	public static void main(String[] args) 
	{
		PolyPractice popeye = new PolyPractice();
		Polynomial poly = new Polynomial(new double[] {-6,-1}); //creates new polynomial poly, which equals -6x^2 + -x
		popeye.addXsquared(poly); //popeye adds x^2 to poly, and then both prints and graphs the resulting polynomial
	}

}
