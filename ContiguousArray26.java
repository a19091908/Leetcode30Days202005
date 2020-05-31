package leetCodeMay2020;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray26 {

	public static void main(String[] args) {
		int[] nums = {0,1,0,1,1,1,0,1,0,0,0};
		int ans = findMaxLength(nums);
		System.out.println(ans);
	}

	private static int findMaxLength(int[] nums) {
		// when we find 1, we add 1, and 
		// when we find 0, we abstract 1.
		// the key of the map is the sum of 0 and 1
		// and the value of the map is the index of this key
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int sum = 0, maxContiguous = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) sum++;
			else sum--;
			
			
			if (sum == 0) maxContiguous = i+1;
			else {
				Integer tempInt = map.get(sum);
				if (tempInt != null) maxContiguous = Math.max(maxContiguous, i-tempInt);
				else map.put(sum, i);
			}

		}
		
		return maxContiguous;
	}

}
