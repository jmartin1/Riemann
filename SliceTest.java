package Riemann;
import polyfun.Polynomial;
//import riemann sum.*;

/**
 * 
 * @author Julia Martin
 * Version: 1.0
 * Date: September-October, 2015
 * 
 * Description: This class tests the Slice method.
 * 
 */

public class SliceTest {
	public static void main(String[] args) 
    {
            LeftHandRule LHR = new LeftHandRule();  //LeftHandRule extends Riemann
            RightHandRule RHR = new RightHandRule();  //RightHandRule extends Riemann
            TrapezoidRule TR= new TrapezoidRule(); //TrapezoidRule extends Riemann
            MidpointRule MR = new MidpointRule(); //MidpointRule extends Riemann
            MinimumRule MINR = new MinimumRule(); //MinimumRule extends Riemann
            MaximumRule MAXR = new MaximumRule(); //MaximumRule extends Riemann
            RandomRule RR = new RandomRule(); //RandomRule extends Riemann
    
            Polynomial p = new Polynomial(new double[] {0,4,0,3}); // p=3x^3+4x
            
            System.out.println(LHR.slice(p,1,1.1)+"\n"); //the area of a left hand rule slice of 3x^3+4x, from x=1 to x=1.1
            
            System.out.println(RHR.slice(p,1,1.1)+"\n"); //the area of a right hand rule slice of 3x^3+4x, from x=1 to x=1.1
            
            System.out.println(TR.slice(p,1,1.1)+"\n"); //the area of a trapezoid rule slice of 3x^3+4x, from x=1 to x=1.1
            
            System.out.println(MR.slice(p,1,1.1)+"\n"); //the area of a midpoint rule slice of 3x^3+4x, from x=1 to x=1.1
            
            System.out.println(MINR.slice(p,1,1.1)+"\n"); //the area of a minimum rule slice of 3x^3+4x, from x=1 to x=1.1
            
            System.out.println(MAXR.slice(p,1,1.1)+"\n"); //the area of a maximum rule slice of 3x^3+4x, from x=1 to x=1.1
            
            System.out.println(RR.slice(p,1,1.1)+"\n"); //the area of a random rule slice of 3x^3+4x, from x=1 to x=1.1
    }
}
