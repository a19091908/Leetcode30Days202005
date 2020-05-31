package leetCodeMay2020;

public class MaximumSumCircularSubarray15 {

	public static void main(String[] args) {
		int[] A = {-2,-3,-1};
		int ans = maxSubarraySumCircular(A);
		System.out.print(ans);
	}

	private static int maxSubarraySumCircular(int[] A) {
		int sum = 0;
		
		int oneArrayAns = findMaxSum(A);
		
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			A[i] = (-1) * A[i];
		}
		
		int twoArrMax = findMaxSum(A);
		
		if (twoArrMax == sum * (-1)) {
			return oneArrayAns;
		}
		int twoArrayAns = sum + twoArrMax;

		return (oneArrayAns > twoArrayAns)? oneArrayAns : twoArrayAns;
	}

	private static int findMaxSum(int[] a) {
		int currSumFrom0 = 0, minSumFrom0 = 0, maxSubArrSum = Integer.MIN_VALUE; 
		
		for (int i = 0; i < a.length; i++) {
			currSumFrom0 += a[i];
			if ( minSumFrom0 <= 0)
				maxSubArrSum = Math.max(maxSubArrSum, currSumFrom0 - minSumFrom0);
			else
				maxSubArrSum = Math.max(maxSubArrSum, currSumFrom0);
			minSumFrom0 = Math.min(minSumFrom0, currSumFrom0);
		}
		return maxSubArrSum;
	}

}
