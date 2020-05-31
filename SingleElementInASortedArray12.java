package leetCodeMay2020;

public class SingleElementInASortedArray12 {

	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3};
		int ans = singleNonDuplicate(nums);
		System.out.println(ans);
	}

	private static int singleNonDuplicate(int[] nums) {
		int head = 0, tail = nums.length-1;
		int mid = -1;
		
		while (head != tail) {
			mid = (head + tail)/2;
			
			if ( ( (tail-head)/2 )%2 == 1) {
				if (nums[mid] == nums[mid-1]) {
					head = mid+1;
				}else if (nums[mid] == nums[mid+1]) {
					tail = mid-1;
				}else {
					return nums[mid];
				}
			}else {
				if (nums[mid] == nums[mid-1]) {
					tail = mid-2;
				}else if (nums[mid] == nums[mid+1]) {
					head = mid+2;
				}else {
					return nums[mid];
				}
			}
			
		}
		
		return nums[head];
	}

}
