package april2020.week2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStone {
	 public int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -Integer.compare(o1, o2);
			}
		});
		
		for (int i = 0; i < stones.length; i++) {
			maxHeap.add(stones[i]);
		}
		while(maxHeap.size() > 1) {
			int n1 = maxHeap.poll();
			int n2 = maxHeap.poll();
			maxHeap.add(n1-n2);
		}
		return maxHeap.peek();
	}

	public static void main(String[] args) {
int stones[]= {2,7,4,1,8,1};
System.out.println(new LastStone().lastStoneWeight(stones));
	}
}
