package leetCodeMay2020;

public class CheckIfItIsAStraightLine8 {

	public static void main(String[] args) {
		int[][] coordinates = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
		boolean ans = checkStraightLine(coordinates);
		System.out.println(ans);
	}

	private static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2) {
			return true;
		}
		
		double m = ((double)coordinates[1][1] - (double)coordinates[0][1]) / 
				((double)coordinates[1][0] - (double)coordinates[0][0]);
		
		for (int i = 2; i < coordinates.length; i++) {
			if (m * ( (double)coordinates[i][0] - (double)coordinates[0][0] ) 
					!= ( (double)coordinates[i][1] - (double)coordinates[0][1] ) ) {
				return false;
			}
		}	
		
		return true;
	}

}
