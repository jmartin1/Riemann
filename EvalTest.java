package Riemann;

import polyfun.Polynomial;
import Riemann.PolyPractice;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: This tests the eval method, which is part of the class PolyPractice.
 */

public class EvalTest {
	public static void main(String [] args) {

		PolyPractice popeye = new PolyPractice();
		Polynomial poly = new Polynomial(new double[] {-6, -1}); //creates new polynomial poly, which equals -6x^2 + -x
		System.out.println(popeye.eval(poly,2.5)); //popeye evaluates poly at 2.5 and the result is printed


	}
}
