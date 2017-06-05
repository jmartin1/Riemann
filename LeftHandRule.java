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
 * Description: The LeftHandRule class implements the left hand rule for finding Riemann sums.
 * It uses the value of the left endpoint of a subinterval to determine the height of the rectangle.
 * Thus, this class finds the Riemann sum at 'sleft' in both slice and slicePlot.
 * 
 * LeftHandRule extends Riemann and implements the abstract methods 'slice' and 'slicePlot'.
 * 
 */

public class LeftHandRule extends Riemann {
	
	/**
	 * Calculates the area of the slice (between the graph of a polynomial and the x-axis, over a given interval on the x-axis) using the left hand rule.
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param sleft
	 * 		The left endpoint of the slice.
	 * @param sright
	 * 		The right endpoint of the slice.
	 * 
	 * @return arealeftslice
	 * 		The area of the slice.
	 * 
	 */
	public double slice(polyfun.Polynomial poly, double sleft, double sright) {
		double arealeftslice = (sright-sleft)*PolyPractice.eval(poly, sleft); //defines arealeftslice as the product of (b-a) and the polynomial evaluated at left endpoint of subinterval 
		return arealeftslice; //returns arealeftslice
	}
	
	/**
	 *  Graphs a slice using the left hand rule.
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
		DrawableShape lefthandrectangle = DrawableShape.createRectangle((sleft + sright)/2, (PolyPractice.eval(poly, sleft))/2, Math.abs(sright-sleft), Math.abs(PolyPractice.eval(poly, sleft))); //creates rectangle with a center that has an x-coordinate that is an average of the left and right endpoints, a center that has a y-coordinate that is the height of the rectangle from the left endpoint divided by two, a width that is the absolute value of sright-sleft, and a height that is the absolute value of the height of the rectangle from the left endpoint 
		lefthandrectangle.color = Color.red; //sets the color of lefthandrectangle to red
		pframe.addDrawable(lefthandrectangle); //adds lefthandrectangle to the frame
		pframe.setVisible(true); //makes the window appear on the screen
	}
}
