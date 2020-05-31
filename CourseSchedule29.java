package leetCodeMay2020;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule29 {

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {
				{0,1}
		};
		
		boolean ans = canFinish(numCourses, prerequisites);
		System.out.println(ans);
	}

	private static boolean canFinish(int numCourses, int[][] prerequisites) {		
		HeadNode[] headNodeArr = new HeadNode[numCourses];
		int[] indirect = new int[numCourses];
		
		// initial HeadNode array.
		for (int i = 0; i < numCourses; i++) 
			headNodeArr[i] = new HeadNode(i);
		
		// tempArr[1] add tempArr[0]
		for (int[] tempArr :prerequisites) {
			headNodeArr[tempArr[1]].list.add(tempArr[0]);
			indirect[tempArr[0]]++;
		}
			
		Queue<Integer> queue = new LinkedList<Integer>();
		
		
		for (int i = 0; i < indirect.length; i++) {
			if (indirect[i] == 0) 
				queue.offer(i);
		}
		
		int arrivedVertex = 0;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			arrivedVertex ++;
			for ( int vertex : headNodeArr[temp].list) {
				indirect[vertex]--;
				if (indirect[vertex] == 0) 
					queue.offer(vertex);
			}	
		}

		return arrivedVertex == numCourses;
	}

}

class HeadNode{
	ArrayList<Integer> list;
	int val;
	public HeadNode(int val) {
		super();
		this.list = new ArrayList<Integer>();
		this.val = val;
	}
	
}
