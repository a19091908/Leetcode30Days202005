package leetCodeMay2020;

public class UncrossedLines25 {

	public static void main(String[] args) {
		int[] A = {1,3,7,1,7,5}, B = {1,9,2,5,1};
		int ans = maxUncrossedLines(A,B);
		System.out.println(ans);
	}

	private static int maxUncrossedLines(int[] A, int[] B) {
		int[][] dp = new int[A.length][B.length];
		
		// initial the first column of the dp array.
		for (int i = 0; i < A.length; i++) {
			if (A[i] == B[0]) {
				while (i < A.length) {
					dp[i][0] = 1;
					i++;
				}
				break;
			}
		}
		
		// initial the first row of the dp array.
		for (int i = 0; i < B.length; i++) {
			if (B[i] == A[0]) {
				while (i < B.length) {
					dp[0][i] = 1;
					i++;
				}
				break;
			}
		}
		
		for (int i = 1; i < A.length; i++) {
			for (int j = 1; j < B.length; j++) {
				if (A[i] == B[j])
					dp[i][j] = dp[i-1][j-1] + 1;
				else 
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		
		return dp[A.length-1][B.length-1];
	}

}
