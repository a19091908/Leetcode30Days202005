package leetCodeMay2020;

public class CountSquareSubmatricesWithAllOnes21 {

	public static void main(String[] args) {
		int[][] matrix = { 
				{ 0, 1, 1, 1 }, 
				{ 1, 1, 1, 1 }, 
				{ 0, 1, 1, 1 } 
				};
		
		int ans = countSquares(matrix);
		System.out.println(ans);
	}

	private static int countSquares(int[][] matrix) {
		int sum = 0;	
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == 1) {
				dp[i][0] = 1;
				sum++;
			}
		}
		
		for (int i = 1; i < m; i++) {
			if (matrix[0][i] == 1) {
				dp[0][i] = 1;
				sum++;
			}
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == 1) {
					int tempMin = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
					dp[i][j] = tempMin;
					sum += tempMin;
				}
			}
		}
		return sum;
	}

}
