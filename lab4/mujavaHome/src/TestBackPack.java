import static org.junit.Assert.*;


import org.junit.Test;

public class TestBackPack {
	@Test
	public void BackPackTest(){
		String str="";
		String res="004444444400455599990045669101111";
		int m = 10;
	    int n = 3;
	   
	    int w[] = {3, 4, 5};
	    int p[] = {4, 5, 6};
		int c[][] = BackPack.BackPack_Solution(m, n, w, p);
		for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
            	str+=c[i][j];
                //System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }
		//String str = "[[I@15db9742, [I@6d06d69c, [I@7852e922, [I@4e25154f]";
		assertEquals(res, str);
	}
}