/**
 * This is the solution for the problem:
 * Stewart Calculus Chapter 9.5 Exercise Problem 2 (d)
 *	Use Euler's Method with step size h=1 to estimate
 *	the population after 50 years if the initial 
 *	population is 1000.
 *
 *	F(t, P) = 0.0015P(1 - (P/6000))
 *
 * @author Craig Spencer craigspencer@modintro.com
 * 
 */

public class EulerMeth {

	public static void main(String args[]) {
		// Set the step size
		int h = 1;

		// Set the initial population size
		double P = 1000;

		// Set time, in years
		int maxTime = 50;

		// Employ Euler's Method
		for(int t = 0; t < maxTime; t=t+h) {
			P = P + 0.0015 * P * (1 - (P/6000));
		}

		// Display output
		System.out.format("The population will be %f after %d years.", P, maxTime);

	}
}

