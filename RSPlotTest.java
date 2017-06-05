package Riemann;
//import riemann sum.*;
import polyfun.Polynomial;
import org.opensourcephysics.frames.*;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: This class tests the RSPlot method.
 * 
 */

public class RSPlotTest {

	public static void main(String[] args) 
	{
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		TrapezoidRule TR = new TrapezoidRule(); //TrapezoidRule extends Riemann
		MidpointRule MR = new MidpointRule(); //MidpointRule extends Riemann
		MinimumRule MINR = new MinimumRule(); //MinimumRule extends Riemann
		MaximumRule MAXR = new MaximumRule(); //MaximumRule extends Riemann
		RandomRule RR = new RandomRule(); //RandomRule extends Riemann

		Polynomial p = new Polynomial(new double[] {3,-6,3}); //p=3x^2-6x+3

		PlotFrame f = new PlotFrame("x","y","Left Hand Riemann Sum Graph"); //LHR Riemann sum graph PlotFrame
		f.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		f.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		f.setVisible(true); //sets frame to visible

		PlotFrame g = new PlotFrame("x","y","Right Hand Riemann Sum Graph"); //RHR Riemann sum graph PlotFrame
		g.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		g.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		g.setVisible(true); //sets frame to visible
		
		PlotFrame h = new PlotFrame("x","y","Trapezoid Riemann Sum Graph"); //TR Riemann sum graph PlotFrame
		h.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		h.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		h.setVisible(true); //sets frame to visible
		
		PlotFrame i = new PlotFrame("x","y","Midpoint Riemann Sum Graph"); //MR Riemann sum graph PlotFrame
		i.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		i.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		i.setVisible(true); //sets frame to visible
		
		PlotFrame j = new PlotFrame("x","y","Minimum Riemann Sum Graph"); //MINR Riemann sum graph PlotFrame
		j.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		j.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		j.setVisible(true); //sets frame to visible
		
		PlotFrame k = new PlotFrame("x","y","Maximum Riemann Sum Graph"); //MAXR Riemann sum graph PlotFrame
		k.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		k.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		k.setVisible(true); //sets frame to visible
		
		PlotFrame l = new PlotFrame("x","y","Random Riemann Sum Graph"); //RR Riemann sum graph PlotFrame
		l.setPreferredMinMaxX(-1, 3); //sets the min and max of frame
		l.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		l.setVisible(true); //sets frame to visible
		

		LHR.rsPlot(f, p, 1, 0.01, 0.0, 2.0, 10); // the left hand rule from x=0 to x=2, with 10 rectangles      

		RHR.rsPlot(g, p, 1, 0.01, 0.0, 2.0, 10); // the right hand rule from x=0 to x=2, with 10 rectangles                            
		
		TR.rsPlot(h, p, 1, 0.01, 0.0, 2.0, 10); // the trapezoid rule from x=0 to x=2, with 10 rectangles
		
		MR.rsPlot(i, p, 1, 0.01, 0.0, 2.0, 10); // the midpoint rule from x=0 to x=2, with 10 rectangles
		
		MINR.rsPlot(j, p, 1, 0.01, 0.0, 2.0, 10); // the minimum rule from x=0 to x=2, with 10 rectangles
		
		MAXR.rsPlot(k, p, 1, 0.01, 0.0, 2.0, 10); // the maximum rule from x=0 to x=2, with 10 rectangles
		
		RR.rsPlot(l, p, 1, 0.01, 0.0, 2.0, 10); // the random rule from x=0 to x=2, with 10 rectangles
	
	}
}
