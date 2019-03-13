package triangle;

public class money {
	public boolean MoneyCal(int money){
		boolean result = false;
		if(money > 0){
			int m1 = 50, m2 = 20, m3 = 5, m4 = 1;
			int n1 = money / m1;
			money = money % m1;
			int n2 = money / m2;
			money = money % m2;
			int n3 = money / m3;
			money = money % m3;
			int n4 = money / m4;
			money = money % m4;
			if(n1 < 2 && n2 < 2 && n3 < 3 && n4 < 4){
				result = true;
			}
		}
		return result;
	}
}
