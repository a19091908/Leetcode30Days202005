package leetCodeMay2020;

import java.util.LinkedList;
import java.util.List;

public class IntervalListIntersections23 {

	public static void main(String[] args) {
		int[][] A = {{0,2},{5,10},{13,23},{24,25}}, B = {{1,5},{8,12},{15,24},{25,26}};
		int[][] ans = intervalIntersection(A,B);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(String.format("{%s,%s}", ans[i][0],ans[i][1]));
		}
	}

	private static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> list = new LinkedList<int[]>();
		int indexA = 0, indexB = 0;
		while (indexA < A.length && indexB < B.length) {
			int lower  = Math.max(A[indexA][0], B[indexB][0]);
			int higher = Math.min(A[indexA][1], B[indexB][1]);
			
			if (lower <= higher) {
				list.add(new int[] {lower,higher});
			}
			
			if (A[indexA][1] > B[indexB][1]) 
				indexB++;
			else 
			if(A[indexA][1] < B[indexB][1])
				indexA++;
			else {
				indexA++;
				indexB++;
			}
		}
		
		return list.toArray(new int[list.size()][2]);
	}

}
