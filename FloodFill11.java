package leetCodeMay2020;

public class FloodFill11 {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1, sc = 1, newColor = 2;
		
		
		int[][] ans = floodFill(image, sr, sc, newColor);
		
		printArr(ans);

	}

	private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		
		drawTheSameColor(image, sr, sc, image[sr][sc], newColor);

		return image;
	}

	private static void drawTheSameColor(int[][] image, int sr, int sc, 
			int target, int newColor) {	
		
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length
				|| image[sr][sc] != target) {
			return;
		}
		
		image[sr][sc] = newColor;
		
		drawTheSameColor(image, sr-1, sc,   target, newColor);
		drawTheSameColor(image, sr+1, sc,   target, newColor);
		drawTheSameColor(image, sr,   sc+1, target, newColor);
		drawTheSameColor(image, sr,   sc-1, target, newColor);
		
	}

	private static void printArr(int[][] ans) {
		for (int[] arr : ans) {
			for (int ele : arr) {
				System.out.print(ele + " ");
			}
			System.out.println("");
		}
	}

}
