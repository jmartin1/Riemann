package Riemann;
import java.awt.Color;
import java.util.Random;

import org.opensourcephysics.display.DrawableShape;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: The RandomRule class implements the random rule for finding Riemann sums.
 * It uses a random value from the range of the left endpoint of the subinterval to the right endpoint of a subinterval to determine the height of each rectangle.
 * 
 * RandomRule extends Riemann and implements the abstract methods 'slice' and 'slicePlot'.
 * 
 */

public class RandomRule extends Riemann{
	Random rand = new Random();
	
	/**
	 * Calculates the area of the slice (between the graph of a polynomial and the x-axis, over a given interval on the x-axis) using the random rule.
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param sleft
	 * 		The left endpoint of the slice.
	 * @param sright
	 * 		The right endpoint of the slice.
	 * 
	 * @return arearandomslice
	 * 		The area of the slice.
	 */
	public double slice(polyfun.Polynomial poly, double sleft, double sright) {
		double x = (rand.nextDouble() * (sright - sleft)) + sleft; //define x as left + difference between right and left * random number
		double arearandomslice = (sright-sleft)*PolyPractice.eval(poly, x); //define arearandomslice as the evaluation of poly at x
		return arearandomslice; //return arearandomslice
	}
	
	/**
	 *  Graphs a slice using the random rule.
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
		double x = (rand.nextDouble() * (sright - sleft)) + sleft; //define x as left + difference between right and left * random number
		double width = Math.abs(sright-sleft); //define width as the difference between the absolute value of the left endpoint and the right endpoint
		double height = PolyPractice.eval(poly, x); //define height as the evaluation of poly at x
		
		DrawableShape randomrectangle = DrawableShape.createRectangle(sleft + (width/2), height/2, Math.abs(width), Math.abs(height));
		randomrectangle.color = Color.red; //sets the color of randomrectangle to red
		pframe.addDrawable(randomrectangle); //adds randomrectangle to the frame
		pframe.setVisible(true); //makes the window appear on the screen
	}
}
