import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class TestBubbleSort {
	@Test
	public void BubbleSortTest(){
		String str = "[1, 2, 2, 5, 6]";
		int arr[] = new int[]{1,6,2,2,5};
        BubbleSort.BubbleSort(arr);
		assertEquals(str, Arrays.toString(arr));
	}
}
