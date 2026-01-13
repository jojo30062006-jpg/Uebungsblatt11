package h2;

public class H2_main {
	public static void main (String [] args) {
		
	System.out.println(fibonacciFolge(20));	
	System.out.println(fibonacci(20));
	System.out.println(fibonacciCached(20));
	
	benchmark(40);
	}
	
	public static void benchmark(int n) {
		
		long start1 = System.nanoTime();
		fibonacci(n);
		long Ende1 = System.nanoTime();
		long Ergebnis1 = Ende1 - start1;
		System.out.println( "Zeit von fibonacci: " + Ergebnis1);
		
		long start2 = System.nanoTime();
		fibonacciCached(n);
		long Ende2 = System.nanoTime();
		long Ergebnis2 = Ende2 - start2;
		System.out.println( "Zeit von fibonacciCached: " + Ergebnis2);
		
		long start3 = System.nanoTime();
		fibonacciFolge(n);
		long Ende3 = System.nanoTime();
		long Ergebnis3 = Ende3 - start3;
		System.out.println( "Zeit von fibonacciFolge: " + Ergebnis3);
	}
	
	public static long fibonacci (int n) {
	
		if(n==0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	static long [] speicher = new long [1000];
	public static long fibonacciCached(int n) {
		
		if(n==0) {
			return 0;
		}
		
		if(n==1) {
			return 1;
		}
		
		if (speicher[n] != 0) {
	           return speicher[n];
	       }

	    speicher[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
	    return speicher[n];
	}
	
	public static long fibonacciFolge (int n) {
		
		if (n == 0) return 0;
	    if (n == 1) return 1;
	    
		long F1 = 0;
		long F2 = 1;
		long Fnext = 0;
			
		for (int i = 2; i <= n; i++) {
			Fnext = F1 + F2;
			F1 = F2;
			F2 = Fnext;
		}
		return Fnext;
	}
}
