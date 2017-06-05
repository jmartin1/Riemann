package Riemann;
import polyfun.Polynomial;
import org.opensourcephysics.frames.*;
//import riemann sum.*;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: This class tests the SlicePlot method.
 * 
 */

public class SlicePlotTest {
	public static void main(String[] args) 
    {
            LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
            RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
            TrapezoidRule TR = new TrapezoidRule(); //TrapezoidRule extends Riemann
            MidpointRule MR = new MidpointRule(); //MidpointRule extends Riemann
            MinimumRule MINR = new MinimumRule(); //MinimumRule extends Riemann
            MaximumRule MAXR = new MaximumRule(); //MaximumRule extends Riemann
            RandomRule RR = new RandomRule(); //RandomRule extends Riemann
    
            Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x
                    
            PlotFrame f = new PlotFrame("x","y","Left Hand Slice"); //LHR slice PlotFrame
            f.setPreferredMinMaxX(.5, 1.5); //sets the min and max of frame
            f.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window                
            f.setVisible(true); //sets frame to visible
                    
            PlotFrame g = new PlotFrame("x","y","Right Hand Rule Slice"); //RHR slice PlotFrame                 
            g.setPreferredMinMaxX(.5,1.5); //sets the min and max of frame
            g.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window
            g.setVisible(true); //sets frame to visible
            
            PlotFrame h = new PlotFrame("x","y","Trapezoid Slice"); //TR slice PlotFrame              
            h.setPreferredMinMaxX(.5,1.5); //sets the min and max of frame
            h.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window
            h.setVisible(true); //sets frame to visible
            
            PlotFrame i = new PlotFrame("x","y","Midpoint Slice"); //MR slice PlotFrame                  
            i.setPreferredMinMaxX(.5,1.5); //sets the min and max of frame
            i.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window
            i.setVisible(true); //sets frame to visible
            
            PlotFrame j = new PlotFrame("x","y","Minimum Slice"); //MINR slice PlotFrame                 
            j.setPreferredMinMaxX(.5,1.5); //sets the min and max of frame
            j.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window
            j.setVisible(true); //sets frame to visible
            
            PlotFrame k = new PlotFrame("x","y","Maximum Slice"); //MAXR slice PlotFrame                
            k.setPreferredMinMaxX(.5,1.5); //sets the min and max of frame
            k.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window
            k.setVisible(true); //sets frame to visible
            
            PlotFrame l = new PlotFrame("x","y","Random Slice"); //RR slice PlotFrame                  
            l.setPreferredMinMaxX(.5,1.5); //sets the min and max of frame
            l.setDefaultCloseOperation(3); //when the integer 3 is passed, the application will close when the user closes the frame window
            l.setVisible(true); //sets frame to visible
                    
            LHR.slicePlot(f, p, 1, 1.1); //a left hand rule slice of 3x^3+4x, from x=1 to x=1.1  
            RHR.slicePlot(g, p, 1, 1.1); //a right hand rule slice of 3x^3+4x, from x=1 to x=1.1
            TR.slicePlot(h, p, 1, 1.1); //a trapezoid rule slice of 3x^3+4x, from x=1 to x=1.1
            MR.slicePlot(i, p, 1, 1.1); //a midpoint rule slice of 3x^3+4x, from x=1 to x=1.1
            MINR.slicePlot(j, p, 1, 1.1); //a minimum rule slice of 3x^3+4x, from x=1 to x=1.1
            MAXR.slicePlot(k, p, 1, 1.1); //a maximum rule slice of 3x^3+4x, from x=1 to x=1.1
            RR.slicePlot(l, p, 1, 1.1); //a random rule slice of 3x^3+4x, from x=1 to x=1.1
    }
}
