/*
 * Link : https://www.acmicpc.net/problem/11725
 * Description : 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하시오.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
	static HashMap<Integer, ArrayList<Integer>> mapTree = new HashMap<Integer, ArrayList<Integer>>();
	static boolean isVisit[];
	static int parents[];
	
	private static void dfs(int idx) {
		isVisit[idx] = true;
		for(int node : mapTree.get(idx)) {
			if(isVisit[node] != true) {
				dfs(node);
				parents[node] = idx;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(br.readLine());
		isVisit = new boolean[num+1];
		parents = new int[num+1];
		
		ArrayList<Integer> arrLink;
		int node1 = 0;
		int node2 = 0;
		for(int i = 0; i < num - 1; i++) {
			String[] nodes = br.readLine().split(" ");
			node1 = Integer.valueOf(nodes[0]);
			node2 = Integer.valueOf(nodes[1]);
			
			if(mapTree.get(node1) == null) {
				arrLink = new ArrayList<Integer>();
			} else {
				arrLink = mapTree.get(node1);
			}
			arrLink.add(node2);
			mapTree.put(node1, arrLink);
			
			if(mapTree.get(node2) == null) {
				arrLink = new ArrayList<Integer>();
			} else {
				arrLink = mapTree.get(node2);
			}
			arrLink.add(node1);
			mapTree.put(node2, arrLink);
		}
		
		dfs(1);
		
		for(int i = 2; i <= num; i++) {
			System.out.println(parents[i]);
		}
	}

}
