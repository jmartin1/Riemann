package Riemann;

import java.awt.Color;

import polyfun.*;

import org.opensourcephysics.*;
import org.opensourcephysics.display.*;


/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: The MidpointRule class implements the midpoint rule for finding Riemann sums.
 * It uses the value of the midpoint of a subinterval to determine the height of the rectangle.
 * Thus, this class finds the Riemann sum at the average of 'sleft' and 'sright' in both slice and slicePlot.
 * 
 * MidpointRule extends Riemann and implements the abstract methods 'slice' and 'slicePlot'. 
 * 
 */

public class MidpointRule extends Riemann {
	/**
	 * Calculates the area of the slice (between the graph of a polynomial and the x-axis, over a given interval on the x-axis) using the midpoint rule.
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param sleft
	 * 		The left endpoint of the slice.
	 * @param sright
	 * 		The right endpoint of the slice.
	 * 
	 * @param areamidslice
	 * 		The area of the slice.
	 */
	public double slice(polyfun.Polynomial poly, double sleft, double sright) {
		double areamidslice = (sright-sleft)*((PolyPractice.eval(poly, sright) + PolyPractice.eval(poly, sleft))/2); //defines areamidslice as the product of (b-a) and the polynomial evaluated at average of the right and left endpoints of the subinterval 
		return areamidslice; //returns areamidslice
	}
	
	/**
	 *  Graphs a slice using the midpoint rule.
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
	public void slicePlot(org.opensourcephysics.frames.PlotFrame pframe, polyfun.Polynomial poly, double sleft, double sright) {
		DrawableShape midpointrectangle = DrawableShape.createRectangle((sleft+sright)/2, (PolyPractice.eval(poly, (sleft+sright)/2)/2), Math.abs(sright-sleft), Math.abs(PolyPractice.eval(poly, (sleft+sright)/2))); //creates rectangle with a center that has an x-coordinate that is an average of the left and right endpoints, a center that has a y-coordinate that is the height of the rectangle from the average of the left and right endpoints divided by two, a width that is the absolute value of sright-sleft, and a height that is the absolute value of the height of the rectangle from the average of the left and right endpoints 
		midpointrectangle.color = Color.red; //sets the color of midpointrectangle to red
		pframe.addDrawable(midpointrectangle); //adds midpointrectangle to the frame
		pframe.setVisible(true); //makes the window appear on the screen
	}
}
