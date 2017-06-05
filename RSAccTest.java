package Riemann;
import polyfun.Polynomial;
import org.opensourcephysics.frames.*;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: This class tests the RSAcc method.
 */

public class RSAccTest {
	public static void main(String[] args) 
	{
		LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
		RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
		TrapezoidRule TR= new TrapezoidRule(); //TrapezoidRule extends Riemann
		MidpointRule MR = new MidpointRule(); //MidpointRule extends Riemann
		MinimumRule MINR = new MinimumRule(); //MinimumRule extends Riemann
		MaximumRule MAXR = new MaximumRule(); //MaximumRule extends Riemann
		RandomRule RR = new RandomRule(); //RandomRule extends Riemann


		Polynomial p = new Polynomial(new double[] {0,1,1}); //p=x^2+x

		PlotFrame f = new PlotFrame("x","y","Left Hand Rule Accumulation Function Graph"); //LHR accumulation function PlotFrame
		f.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		f.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		f.setVisible(true); //sets frame to visible

		PlotFrame g = new PlotFrame("x","y","Right Hand Rule Accumulation Function Graph"); //RHR accumulation function PlotFrame
		g.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		g.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window 
		g.setVisible(true); //sets frame to visible

		PlotFrame i = new PlotFrame("x","y","Trapezoid Rule Accumulation Function Graph"); //TR accumulation function PlotFrame
		i.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		i.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window                   
		i.setVisible(true); //sets frame to visible

		PlotFrame j = new PlotFrame("x","y","Midpoint Rule Accumulation Function Graph"); //MR accumulation function PlotFrame
		j.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		j.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window                 
		j.setVisible(true); //sets frame to visible

		PlotFrame k = new PlotFrame("x","y","Minimum Rule Accumulation Function Graph"); //MINR accumulation function PlotFrame
		k.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		k.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window                   
		k.setVisible(true); //sets frame to visible

		PlotFrame l = new PlotFrame("x","y","Maximum Rule Accumulation Function Graph"); //MAXR accumulation function PlotFrame
		l.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		l.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window                   
		l.setVisible(true); //sets frame to visible

		PlotFrame m = new PlotFrame("x","y","Random Rule Accumulation Function Graph"); //RR accumulation function PlotFrame
		m.setPreferredMinMaxX(-3, 3); //sets the min and max of frame
		m.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window                   
		m.setVisible(true); //sets frame to visible



		LHR.rsAcc(f, p, 2, .01, -1.0); //plots the left hand rule accumulation function of x^2+x, with base x=-1;

		RHR.rsAcc(g, p, 2, .01, -1.0); //plots the right hand rule accumulation function of x^2+x, with base x=-1;

		TR.rsAcc(i, p, 2, .01, -1.0); //plots the trapezoid rule accumulation function of x^2+x, with base x=-1;   

		MR.rsAcc(j, p, 2, .01, -1.0); //plots the midpoint rule accumulation function of x^2+x, with base x=-1;  

		MINR.rsAcc(k, p, 2, .01, -1.0); //plots the minimum rule accumulation function of x^2+x, with base x=-1;

		MAXR.rsAcc(l, p, 2, .01, -1.0); //plots the maximum rule accumulation function of x^2+x, with base x=-1;

		RR.rsAcc(m, p, 2, .01, -1.0); //plots the maximum rule accumulation function of x^2+x, with base x=-1;

	}
}
