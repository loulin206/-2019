package st.se.tju;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import primes.PrintPrimes;

@RunWith(Parameterized.class)
public class TestPrintPrimes {
	private int input;
	private String expected;
	private PrintPrimes pri;
	public TestPrintPrimes(int input, String expected){
		this.input = input;
		this.expected = expected;
	}
	
	@Before
	public void setUP(){
		this.pri = new PrintPrimes();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{3,"Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n"},
			{4,"Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\n"},
			{5,"Prime: 2\r\nPrime: 3\r\nPrime: 5\r\nPrime: 7\r\nPrime: 11\r\n"}
		});
	}
	
	@Test
	public void PrintPrimesTest(){
		assertEquals(this.expected, pri.printPrimes(input));
		System.out.println(pri.printPrimes(input));
	}
}
