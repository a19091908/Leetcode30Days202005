package leetCodeMay2020;

public class PossibleBipartition27 {

	public static void main(String[] args) {
		int N = 5;
		int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}};
		boolean ans = possibleBipartition(N,dislikes);
		System.out.println(ans);
	}

	private static boolean possibleBipartition(int N, int[][] dislikes) {
		boolean[][] dislikeGraph = new boolean[N+1][N+1];
		
		for (int i = 0; i < dislikes.length; i++) {
			dislikeGraph[dislikes[i][0]][dislikes[i][1]] = true;
			dislikeGraph[dislikes[i][1]][dislikes[i][0]] = true;
		}
		
		int[] colors = new int[N+1];
		
		for (int i = 1; i < colors.length; i++) {
			if (colors[i] == 0) {
				boolean isDrawSucceed = drawColor(i, 1, colors, dislikeGraph);
				if (!isDrawSucceed) {
					return false;
				}
			}
		}
		
		return true;

	}

	private static boolean drawColor(int index, int color, int[] colors, boolean[][] dislikeGraph) {
		
		if (colors[index] != 0) {
			return colors[index] == color;
		}
		
		colors[index] = color;
		
		for (int j = 1; j < dislikeGraph[index].length; j++) {
			if (dislikeGraph[index][j]) {
				boolean isDrawSucceed = drawColor(j, -color, colors, dislikeGraph);
				if (!isDrawSucceed) {
					return false;
				}
			}
		}
		
		return true;
	}

}
