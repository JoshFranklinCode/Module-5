/**
 * This Fibonacci program will use recursive and iterative functions in order to
 * find the number within the Fibonacci sequence at the placement of the desired
 * number of "n". The recursive method will loop multiple times up to and including
 * "n" using the method "public int fibonacci(int n)". The iterative function will
 * loop through the "public void run()" function and iterate through a list in order
 * to determine the Fibonacci number at the placement of "n". After each loop in
 * both the iterative and recursive functions, the system will print the number found
 * at the position of "n" and will print which thread found the answer, the number
 * found, and how long it took to determine that number (In nanoseconds).
 */
package softwareDev;

import softwareDev.fibonacciDynamic;
import softwareDev.fibonacciRecursion;

/**
 * module5 class will contain the main method that is responsible for starting
 * each fibonacci sequence class.
 * 
 * @author Joshua
 *
 */
public class module5 {
	/**
	 * Main method will create each Fibonacci sequence class in both recursive and
	 * dynamic fashion, then run each one.
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// Setting classes
		fibonacciRecursion recursion = new fibonacciRecursion();
		fibonacciDynamic dynamic = new fibonacciDynamic();

		// Start Threads
		recursion.start();
		dynamic.start();
	}
}

/**
 * The fibonacciRecursion class will run the fibonacci sequence and find the
 * 40th number (In reference to the number set to "n"), then display the number
 * and how long it took to get to it.
 * 
 * @author Joshua
 *
 */
class fibonacciRecursion extends Thread {
	// Set to desired position in sequence
	int n = 10;

	/**
	 * run method responsible for finding each amount of time spent getting final
	 * answer by sending "n" to the fibonacci method, then printing said answer to
	 * the console. Will repeat this method multiple times up to a desired placement
	 * of fibonacci number (Max of 40 by default).
	 */
	public void run() {
		// Get times and run sequence method
		while (n <= 40) {
			long time1 = System.nanoTime();
			int answer = fibonacci(n);
			long time2 = System.nanoTime();
			// Print answer + time thread took to find it
			System.out.println("Recursion Thread found the answer: " + answer + " in " + (time2 - time1) + "ns");
			n = n + 10;
		}
	}

	// Recursion Fibonacci method
	/**
	 * Fibonacci method responsible for finding the fibonacci sequence leading up to
	 * the "n"th number, then returning that value back to the previous method.
	 * 
	 * @param n
	 * @return
	 */
	public int fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}

/**
 * The fibonacciDynamic (Iterative) class will run the Fibonacci sequence and
 * find the 40th number (In reference to the number set to "n"), then display
 * the number and how long it took to get to it.
 * 
 * @author Joshua
 *
 */
class fibonacciDynamic extends Thread {
	// Set to desired position in sequence
	int n = 10;

	/**
	 * run method responsible for finding and printing the amount of time spent
	 * finding number in "n"th place. Will repeat this method multiple times up to a
	 * desired placement of fibonacci number (Max of 40 by default).
	 * 
	 */
	public void run() {
		while (n <= 40) {
			// Get time and set variables
			long time1 = System.nanoTime();
			int v1 = 0, v2 = 1, v3 = 0;

			System.out.print("Dynamic Thread found the answer: ");
			// Dynamic Fibonacci sequence
			for (int i = 2; i <= n; i++) {
				v3 = v1 + v2;
				v1 = v2;
				v2 = v3;
			}
			long time2 = System.nanoTime();
			// Print answer + time thread took to find it
			System.out.println(v3 + " in " + (time2 - time1) + "ns");
			n = n + 10;
		}
	}
}