package leetCodeMay2020;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement6 {

	public static void main(String[] args) {
		int[] nums = {2,2,1,1,1,2,2};
		int ele = run(nums);
		System.out.println(ele);
	}

	private static int run(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		Integer tempInt, max, ele = -1;
		
		for(int num: nums) {
			tempInt = map.get(num);
			if (tempInt == null) {
				map.put(num, 1);
			}else {
				map.put(num, ++tempInt);
			}
		}
		
		max = Integer.MIN_VALUE;
		for(Integer key:map.keySet()) {
			tempInt = map.get(key);
			if (max < tempInt) {
				max = tempInt;
				ele = key;
			}
		}
		
		return ele;
	}

}
