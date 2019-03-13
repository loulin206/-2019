package st.se.tju;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import triangle.money;

@RunWith(Parameterized.class)

public class TestMoneyCal {
	
	/*@Test
	public void TestM(){
		money moneyCal = new money();
		assertTrue(moneyCal.MoneyCal(71));
	}*/
	private int input1;
	private money mon = null;
	public TestMoneyCal(int input1){
		this.input1 = input1;
	}
	
	@Before
	public void setUP(){
		mon = new money();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{70},
			{73},
			{79}
		});
	}
	
	@Test
	public void TestM(){
		assertTrue(mon.MoneyCal(input1));
	}
	
}