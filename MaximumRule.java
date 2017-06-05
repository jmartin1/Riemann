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
 * Description: The MaximumRule class implements the maximum rule for finding Riemann sums.
 * It determines the height of the rectangle with the right endpoint and determines the height of the rectangle with the left endpoint.
 * Whichever height is greater is the height used to calculate the area of the slice.
 * 
 * MaximumRule extends Riemann and implements the abstract methods 'slice' and 'slicePlot'.
 */

public class MaximumRule extends Riemann {
	double height; //declares height, which will be the height of the rectangle we will use to calculate the area of the slice 

	/**
	 * Calculates the area of the slice (between the graph of a polynomial and the x-axis, over a given interval on the x-axis) using the maximum hand rule.
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param sleft
	 * 		The left endpoint of the slice.
	 * @param sright
	 * 		The right endpoint of the slice.
	 * 
	 * @return areamaximumslice
	 * 		The area of the slice.
	 * 
	 */
	public double slice(polyfun.Polynomial poly, double sleft, double sright) {
		double h1 = PolyPractice.eval(poly, sleft); //defines h1 as the height of the rectangle from endpoint 'sleft'
		double h2 = PolyPractice.eval(poly, sright); //defines h2 as the height of the rectangle from endpoint 'sright'

		//if the height of the rectangle from 'sleft' is less than the height of the rectangle from 'sright', define height as being the height of the rectangle from 'sright'
		if (h1 < h2) 
		{
			height = h2;
		}
		//else define height as being the height of the rectangle from 'sleft'
		else
		{
			height = h1;
		}

		double areamaximumslice = (sright-sleft)*height; //defines areamaximumslice as the product of (b-a) and the polynomial evaluated at either 'sleft' or 'sright,' depending on which resulting height evaluated is greater 
		return areamaximumslice; //returns areamaximumslice
	}
	
	/**
	 * Graphs a slice using the maximum rule.
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
		//if the height of the rectangle evaluated from 'sleft' is less than the height of the rectangle evaluated from 'sright,' then do the following:
		if (PolyPractice.eval(poly, sleft) < PolyPractice.eval(poly, sright)) {
			DrawableShape maximumrectangle = DrawableShape.createRectangle((sleft + sright)/2, PolyPractice.eval(poly, sright)/2, Math.abs(sright-sleft), Math.abs(PolyPractice.eval(poly, sright))); //creates rectangle with a center that has an x-coordinate that is an average of the left and right endpoints, a center that has a y-coordinate that is the height of the rectangle from the right endpoint divided by two, a width that is the absolute value of sright-sleft, and a height that is the absolute value of the height of the rectangle from the right endpoint
			maximumrectangle.color = Color.red; //sets the color of the rectangle to red
			pframe.addDrawable(maximumrectangle); //adds maximumrectangle to the frame
			pframe.setVisible(true); //makes the window appear on the screen
		}
		//if the height of the rectangle evaluated from 'sright' is less than the height of the rectangle evaluated from 'sleft,' then do the following:
		if (PolyPractice.eval(poly, sright) < PolyPractice.eval(poly, sleft)) {
			DrawableShape maximumrectangle = DrawableShape.createRectangle((sleft + sright)/2, PolyPractice.eval(poly, sleft)/2, Math.abs(sright-sleft), Math.abs(PolyPractice.eval(poly, sleft))); //creates rectangle with a center that has an x-coordinate that is an average of the left and right endpoints, a center that has a y-coordinate that is the height of the rectangle from the left endpoint divided by two, a width that is the absolute value of sright-sleft, and a height that is the absolute value of the height of the rectangle from the left endpoint
			maximumrectangle.color = Color.red; //sets the color of the rectangle to red
			pframe.addDrawable(maximumrectangle); //adds maximumrectangle to the frame
			pframe.setVisible(true); //makes the window appear on the screen
		}
	}
}
