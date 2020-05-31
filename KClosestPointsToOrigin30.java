package leetCodeMay2020;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin30 {

	public static void main(String[] args) {
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int K = 2;
		int[][] ans = kClosest(points, K);
		for (int[] arr : ans) 
			System.out.println(String.format("{%s,%s}", arr[0],arr[1]));

	}

	private static int[][] kClosest(int[][] points, int K) {
		Queue<XYNode> queue = new PriorityQueue<XYNode>(new Comparator<XYNode>() {
			@Override
			public int compare(XYNode o1, XYNode o2) {
				return o1.dist-o2.dist;
			}
		});
		
		for (int i = 0 ; i < points.length ; i++) 
			queue.offer(new XYNode(points[i][0], points[i][1]));
		
		int[][] ansArr = new int[K][2];
		for (int i = 0; i < K; i++) {
			XYNode temp = queue.poll();
			ansArr[i] = new int[] {temp.x,temp.y};
		}
		
		return ansArr;
	}
	

}

class XYNode{
	int dist;
	int x;
	int y;
	XYNode(int x, int y){
		this.dist = x*x+y*y;
		this.x = x;
		this.y = y;
	}
}


