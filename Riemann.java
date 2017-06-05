package Riemann;

import org.opensourcephysics.display.Trail;
import org.opensourcephysics.frames.PlotFrame;

import polyfun.Coef;
import polyfun.Term;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description:
 * This abstract class contains the method for calculating a Riemann sum (rs) of a given polynomial, over a given interval, using a given number of subintervals; the method for graphing the Riemann sum (rsPlot); and the method for graphing an accumulation function (rsAcc) corresponding to a given polynomial and a given left hand endpoint for all the rules.
 * In addition, this abstract class contains abstract methods implemented by each rule - slice plot and slice - that define the individual rules. slice calculates the (signed) area between the graph of a polynomial and the x-axis, over a given interval on the x-axis. slicePlot draws the region whose area is calculated by slice.  
 * 
 */

public abstract class Riemann {
	int left;
	int right;
	int subintervals;
	double delta;

	public Riemann()
	{
		//default constructor does nothing
	}

	/**
	 * This is a getter for the left hand endpoint.
	 * 
	 * @return left
	 * 		The left hand endpoint.
	 * 
	 */
	public int getLeft() {
		return left;
	}

	/**
	 * This is a setter for the left hand endpoint.
	 * 
	 * @param left
	 * 		The left hand endpoint.
	 */
	public void setLeft(int left) {
		this.left = left;
	}

	/**
	 * This is a getter for right hand endpoint.
	 * 
	 * @return right
	 * 		The right hand endpoint
	 */
	public int getRight() {
		return right;
	}

	/**
	 * This is a setter for the right hand endpoint.
	 * 
	 * @param right
	 * 		The right hand endpoint.
	 */
	public void setRight(int right) {
		this.right = right;
	}

	/**
	 * This is a getter for the number of subintervals.
	 * 
	 * @return subintervals
	 * 		The number of subintervals.
	 */
	public int getSubintervals() {
		return subintervals;
	}

	/**
	 * This is a setter for the number of subintervals.
	 * 
	 * @param subintervals
	 * 		The number of subintervals.
	 */
	public void setSubintervals(int subintervals) {
		this.subintervals = subintervals;
	}

	/**
	 * This is a getter for delta, the width of each subinterval.
	 * 
	 * @return delta
	 * 		The width of each subinterval.
	 */
	public double getDelta() {
		return delta;
	}

	/**
	 * This is a setter for delta, the width of each subinterval.
	 * 
	 * @param delta
	 * 		The width of each subinterval.
	 */
	public void setDelta(double delta) {
		this.delta = delta;
	}


	/**
	 * This constructor takes as input the left and right endpoints of the interval over which the Riemann sum is to be calculated, and the number of subintervals used to calculate the Riemann sum.
	 * It sets delta equal to (right - left)/subintervals. 
	 * 
	 * @param left
	 * 		The left hand endpoint.
	 * @param right
	 * 		The right hand endpoint.
	 * @param subintervals
	 * 		The number of subintervals.
	 */
	public Riemann(double left,double right, int subintervals) {
		delta = (right-left)/subintervals; //defines delta as (b-a)/subintervals
	}

	/**
	 * This method calculates a Riemann sum from a left endpoint, a right endpoint, a polynomial, and the number of subintervals. 
	 * If RiemannSumRule extends Riemann and RSR is an object of type RiemannSumRule, then RSR.rs should calculate a Riemann sum using the particular Riemann sum rule implemented in RiemannSumRule. 
	 * 
	 * @param poly
	 * 		The polynomial used to evaluate the slice.
	 * @param left
	 * 		The left hand endpoint.
	 * @param right
	 * 		The right hand endpoint.
	 * @param subintervals
	 * 		The number of subintervals.
	 * 
	 * @return area
	 * 		The value of the Riemann sum, calculated according to a particular rule which is determined by the child class that extends this method.
	 */
	public double rs(polyfun.Polynomial poly, double left, double right, int subintervals) {

		delta = (right-left)/subintervals; //defines delta as (b-a)/subintervals
		double area = 0; //declares area
		for(double i = 0; i <= subintervals; i++){ //for loop that continues looping until the areas of all the slices have been added
			area += slice(poly, left, left+delta); //adds the area of slice with the endpoints left and left+delta to the existing area
			left += delta; //increments left by delta
		}
		return area;  //returns area
	}

	 
	/**
	 * This method graphs the input polynomial on the input PlotFrame. It also draws the regions used to calculate a particular Riemann sum.
	 * If RiemannSumRule extends Riemann and RSR is an object of type RiemannSumRule, then RSR.rsPlot should graph the input polynomial and draw the regions used to calculate the Riemann sum using the rule implemented in RiemannSumRule.
	 * 
	 * @param pframe
	 * 		The PlotFrame on which the polynomial and the Riemann sum are drawn.
	 * @param poly
	 * 		The polynomial whose Riemann sum is to be drawn.
	 * @param index
	 * 		The number associated to the collection of (x,y) coordinates that make up the dataset which, when plotted, is the graph of the polynomial.
	 * @param precision
	 * 		The difference between the x-coordinates of two adjacent points on the graph of the polynomial.
	 * @param left
	 * 		The left hand endpoint of the Riemann sum.
	 * @param right
	 * 		The right hand endpoint of the Riemann sum.
	 * @param subintervals
	 * 		The number of subintervals in the Riemann sum.
	 */
	public void rsPlot(org.opensourcephysics.frames.PlotFrame pframe, polyfun.Polynomial poly, int index, double precision, double left, double right, int subintervals) {
		//GRAPHS PARABOLA:
		Trail t = new Trail(); //create new trail
		pframe.setVisible(true); //make window appear on screen
		for(double x = -100; x < 100; x+=precision){
			Coef C = poly.evaluate(x); //sets coeff C to p(x)
			Term T = C.getTerms()[0]; //converts coeff into a term
			double y = T.getTermDouble(); //converts term into a double
			t.addPoint(x,y); //adds point (x, p(x)) to trail
		}
		pframe.addDrawable(t); //adds trail to frame

		//GRAPHS EACH SLICE:
		delta = (right-left)/subintervals; //defines delta as (b-a)/subintervals
		for(double i = left; i <= (right-delta); i += delta) { //for loop that continues incrementing the left endpoint by delta until the left endpoint is delta away from the right hand endpoint
			slicePlot(pframe, poly, i, i + delta); //graphs each slice with the left and left+delta endpoints
		}

	}	


	/**
	 * This method graphs the accumulation function corresponding to the input polynomial and the input left hand endpoint.
	 * If RiemannSumRule extends Riemann and RSR is an object of type RiemannSumRule, then RSR.rsAcc should graph the accumulation function corresponding to the input polynomial and the input left hand endpoint using the particular Riemann sum rule implemented in RiemannSumRule. 
	 * 
	 * @param pframe
	 * 		The PlotFrame on which the polynomial and the Riemann sum are drawn.	
	 * @param poly
	 * 		The polynomial whose accumulation function is to be calculated.
	 * @param index
	 * 		The number associated to the collection of (x,y) coordinates that make up the dataset which, when plotted, is the graph of the accumulation function.
	 * @param precision
	 * 		The difference between the x-coordinates of two adjacent points on the graph of the accumulation function.
	 * @param base
	 * 		The left hand endpoint of the accumulation function.
	 */
	public void rsAcc(org.opensourcephysics.frames.PlotFrame pframe, polyfun.Polynomial poly, int index, double precision, double base) {
		//CREATE TRAIL:
		double x = 10; //declares x
		Trail acctrail = new Trail(); //creates new trail
		for(double i = base-x; i <= base + x; i+=precision){ //for loop that continues looping until i is less than or equal to base + x
			acctrail.addPoint(i, rs(poly, base, i, 200)); //adds point (i, area of slice under poly above the x-axis with endpoints base and i and 200 subintervals) to trail
		}
		pframe.addDrawable(acctrail); //adds trail to frame
		pframe.setVisible(true); //makes window appear on screen
	}


	public abstract double slice(polyfun.Polynomial poly, double sleft, double sright); //abstract method implemented by each rule that calculates the area of a slice of a Riemann sum
	
	public abstract void slicePlot(org.opensourcephysics.frames.PlotFrame pframe, polyfun.Polynomial poly, double sleft, double sright); //abstract method implemented by each rule that plots a slice
}