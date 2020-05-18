package april2020.week1;

public class BuySellStock {
	public int maxProfit(int[] prices) {
		int i = 0;
		int profit = 0;
		while (i < prices.length) {
			int j = i + 1;
			while (j < prices.length && prices[j] > prices[j - 1]) {
				j++;
			}
			j--;
			if (prices[j] > prices[i]) {
				profit += prices[j] - prices[i];
				i = j + 1;
			} else {
				i++;
			}
		}
		return profit;
	}

	public static void main(String[] args) {
		int prices[] = { 7, 6, 4, 3, 1 };
		System.out.println(new BuySellStock().maxProfit(prices));
	}
}
