package april2020.week1;

import java.util.HashSet;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		HashSet<Integer> check = new HashSet<>();
		for(Integer i:nums) {
			if(!check.contains(i)) check.add(i);
			else check.remove(i); 
		}
		Integer a[] = new Integer[nums.length];
		check.toArray(a);
		return a[0];
	}
	
	public int singleNumber2(int[] nums) {
		int a = nums[0];
		for(int i=1;i<nums.length;i++) {
			 a = a^nums[i];
		}
		return a;
	}

	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println(new SingleNumber().singleNumber2(nums));
//		System.out.println(0^1);
	}
}
