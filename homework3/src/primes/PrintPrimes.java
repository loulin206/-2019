package primes;

public class PrintPrimes {
	
	
	public boolean isDivisible (int i, int j)
	{
	   if (j%i == 0)
	      return true;
	   else
	      return false;
	}
	public String printPrimes (int n)
	{
	   String str = new String("");
	   int curPrime;           
	   int numPrimes;         
	   boolean isPrime;        
	   int [] primes = new int [100]; 
	   primes [0] = 2;
	   numPrimes = 1;
	   curPrime  = 2;
	   while (numPrimes < n)
	   {
	      curPrime++;  // next number to consider ...
	      isPrime = true;
	      for (int i = 0; i <= numPrimes-1; i++)
	      {   // for each previous prime.
	         if (isDivisible (primes[i], curPrime))
	         {  // Found a divisor, curPrime is not prime.
	            isPrime = false;
	            break; // out of loop through primes.
	         }
	      }
	      if (isPrime)
	      {   // save it!
	         primes[numPrimes] = curPrime;
	         numPrimes++;
	      }
	   }  // End while

	   // Print all the primes out.
	   for (int i = 0; i <= numPrimes-1; i++)
	   {
		   str=str+"Prime: " + primes[i] +"\r\n";
		   //System.out.println ("Prime: " + primes[i]);
	   }
	   return str;
	}  // end printPrimes

}
