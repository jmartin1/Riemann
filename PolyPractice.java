package Riemann;
import polyfun.*;

import org.opensourcephysics.*;
import org.opensourcephysics.display.Trail;
import org.opensourcephysics.frames.PlotFrame;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: November-December, 2015
 * 
 * Description: This is the class PolyPractice, which imports the polyfun package. It contains the methods eval and addxsquared.
 * 
 */

public class PolyPractice {
	
	/** 
	 * Evaluates a polynomial at a given x-coordinate. 
	 * 
	 * @param p
	 * 		The polynomial used to evaluate. 
	 * @param x
	 * 		The x point to evaluate at.
	 * 
	 * @return y
	 * 		The y-coordinate of the point on the polynomial.
	 *  
	 */
	
	public static double eval(Polynomial p, double x) {
		Coef C = p.evaluate(x); //sets coeff C to p(x)
		Term T = C.getTerms()[0]; //converts coeff into a term
		double y = T.getTermDouble(); //converts term into a double
		return y; //returns y
	}
	
	/**
	 * Prints the sum of the polynomial x2 and the input polynomial, and it graphs this sum of polynomials on a PlotFrame.
	 * 
	 * @param p
	 * 		The polynomial to which an x^2 is added.
	 * 
	 */
	
	public void addXsquared(Polynomial p) {
		
		Polynomial r = new Polynomial(1, 2); //creates new polynomial, r = x^2 + 2x
		Polynomial q = r.plus(p); //adds x^2 to r
		Trail t = new Trail(); //creates new trail
		PlotFrame trailframe = new PlotFrame("x-axis","y-axis","Trail Frame"); //creates frame
		trailframe.setVisible(true); //makes window appear on screen
		for(int i = -50; i < 50; i++){
			t.addPoint(i, eval(q,i)); //adds points to trail
		}
		t.closeTrail(); //closes trail
		trailframe.addDrawable(t); //adds trail to frame
		
		
	}
	
}
