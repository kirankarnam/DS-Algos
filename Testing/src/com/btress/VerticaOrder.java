package com.btress;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class VerticaOrder {
	
	  
	private static Map<Integer, List<Integer>> mapVerticalDistance = null;
	
	public static void main(String args[]) {
		
	}
	
	/*
	 * FIND THE horixontal distance from the node and print min to max in order
	 * 
	 * 
	 * Level order traversal + hashmap
	 */
/*	static void verticalOrder(TreeNode root) {
		PriorityQueue<TreeNode> queue = new PriorityQueue<>();
		Queue<Integer> cols = new LinkedList<>();
		
		
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		queue.add(root);
		cols.add(0);
		
		//map.put(0, root);
		
		int minLevel = 0;
		int maxLevel = 0;
		while(!queue.isEmpty()) {
			
			TreeNode temp = queue.poll();
			int col = cols.poll();
			map.putIfAbsent(col, new ArrayList<Integer>());
			map.get(col).add(temp.data);
			
			
			if(temp.left != null) {
				queue.add(temp.left);
				cols.add(col - 1);
				minLevel = Math.min(minLevel, col - 1);
			}else if(temp.right != null) {
				queue.add(temp.right);
				cols.add(col + 1);
				maxLevel = Math.max(maxLevel, col + 1);
			}
					
		}
		
	}*/
	
	static void verticalOrder(TreeNode root,int distance) {
		if(root ==null)
			return;
		List<Integer> list = null;
		
		if(mapVerticalDistance.containsKey(distance)) {
			list = mapVerticalDistance.get(distance);
		}else {
			list = new ArrayList<Integer>();
		}
		
		list.add(root.data);
		
		mapVerticalDistance.put(distance, list);
		verticalOrder(root.left, distance - 1);
		verticalOrder(root.right, distance + 1);
			
		
		
	}
	
	public static void verticalOrder(TreeNode root) {
		if (null == mapVerticalDistance) {
			mapVerticalDistance = new HashMap<Integer, List<Integer>>();
		} else {
			mapVerticalDistance.clear();
		}
		
		verticalOrder(root, 0);
		mapVerticalDistance
				.forEach(
						(k, v) 
							-> System.out.println("Nodes at distance " + k + " = " + v));
	}

}
