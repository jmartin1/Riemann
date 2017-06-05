package Riemann;
import polyfun.*;

import org.opensourcephysics.display.Trail;
import org.opensourcephysics.*;
import org.opensourcephysics.frames.PlotFrame;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: The TrapezoidRule class evaluates Riemann sums by creating a trapezoid out of a subinterval.
 * The TrapezoidRule calculates area in 'slice' using the trapezoid area formula h*(b1+b2)/2, where b1 and b2 are p(sleft) and p(sright), respectively, where p(x) is the polynomial used to calculate the Riemann sum. 
 * The Trapezoid Rule essentially calculates an average of the LHR and RHR; b1 in the trapezoid rule is the height of a rectangle using the LHR and b2 is the height of a rectangle using the RHR. Thus, the trapezoid rule is an average of the LHR and RHR. 
 * 
 * TrapezoidRule extends Riemann and implements the abstract methods 'slice' and 'slicePlot'. 
 * 
 */

public class TrapezoidRule extends Riemann{
	/**
	 * Calculates the area of the slice (between the graph of a polynomial and the x-axis, over a given interval on the x-axis) using the trapezoid rule.
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param sleft
	 * 		The left endpoint of the slice.
	 * @param sright
	 * 		The right endpoint of the slice.
	 * 
	 */
	public double slice(polyfun.Polynomial poly, double sleft, double sright) {
		double areatrapslice = (sright-sleft)*((PolyPractice.eval(poly, sright)+PolyPractice.eval(poly, sleft))/2); //defines arealeftslice as the product of (b-a) and the average of the polynomial evaluated at left endpoint of subinterval and the polynmial evaluated at the right endpoint of subinterval
		return areatrapslice; //returns areatrapslice
	}

	/**
	 *  Graphs a slice using the trapezoid rule.
	 *  
	 *  @param pframe
	 *  	The plotframe used to graph the slices.
	 *  @param poly
	 *  	The polynomial used to graph the slices.
	 *  @param sleft
	 * 		The left endpoint of the slice.
	 *  @param sright
	 * 		The right endpoint of the slice.
	 * 
	 */
	@Override
	public void slicePlot(PlotFrame pframe, Polynomial poly, double sleft, double sright) {
		Trail traptrail = new Trail(); //create new trail called traptrail
		pframe.setVisible(true); //makes the window appear on the screen
		traptrail.addPoint(sleft, 0); //adds initial point (sleft, 0) to traptrail
		traptrail.addPoint(sright, 0); //adds points to traptrail until it gets to the next vertex of the trapezoid at (sright, 0)
		traptrail.addPoint(sright, PolyPractice.eval(poly, sright)); //adds points to traptrail until it gets to the next vertex of the trapezoid at the evaluated poly function at sright
		traptrail.addPoint(sleft, PolyPractice.eval(poly, sleft)); //adds points to traptrail until it gets to the next vertex of the trapezoid at the evaluated poly function at sleft
		traptrail.addPoint(sleft, 0); //adds points to traptrail in the y-direction until it gets back to the initial point and vertex of the trapezoid at (sleft, 0)
		pframe.addDrawable(traptrail); //adds traptrail to frame

	}


}

