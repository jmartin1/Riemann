package Riemann;

import java.awt.Color;
import polyfun.*;
import org.opensourcephysics.*; 
import org.opensourcephysics.display.DrawableShape;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: The RightHandRule class implements the right hand rule for finding Riemann sums.
 * It uses the value of the right endpoint of a subinterval to determine the height of the rectangle.
 * Thus, this class finds the Riemann sum at 'sright' in both slice and slicePlot.
 * 
 * RightHandRule extends Riemann and implements the abstract methods 'slice' and 'slicePlot'.
 * 
 */

public class RightHandRule extends Riemann {
	/**
	 * Calculates the area of the slice (between the graph of a polynomial and the x-axis, over a given interval on the x-axis) using the right hand rule.
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param sleft
	 * 		The left endpoint of the slice.
	 * @param sright
	 * 		The right endpoint of the slice.
	 * 
	 * @return arearightslice
	 * 		The area of the slice.
	 */
	public double slice(polyfun.Polynomial poly, double sleft, double sright) {
		double arearightslice = (sright-sleft)*PolyPractice.eval(poly, sright); //defines arearightslice as the product of (b-a) and the polynomial evaluated at right endpoint of subinterval
		return arearightslice; //returns arearightslice
	}

	/**
	 *  Graphs a slice using the right hand rule.
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
		DrawableShape righthandrectangle = DrawableShape.createRectangle((sleft + sright)/2, (PolyPractice.eval(poly, sright))/2, Math.abs(sright-sleft), Math.abs(PolyPractice.eval(poly, sright))); //creates rectangle with a center that has an x-coordinate that is an average of the left and right endpoints, a center that has a y-coordinate that is the height of the rectangle from the right endpoint divided by two, a width that is the absolute value of sright-sleft, and a height that is the absolute value of the height of the rectangle from the right endpoint
		righthandrectangle.color = Color.red; //sets the color of righthandrectangle to red
		pframe.addDrawable(righthandrectangle); //adds righthandrectangle to the frame
		pframe.setVisible(true); //makes the window appear on the screen
	}

}
