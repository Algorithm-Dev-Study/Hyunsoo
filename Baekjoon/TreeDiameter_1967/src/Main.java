/*
	Link : https://www.acmicpc.net/problem/1967
	Description : 입력으로 루트가 있는 트리를 가중치가 있는 간선들로 줄 때, 트리의 지름을 구해서 출력하는 프로그램을 작성
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static boolean[] isVisit;
	private static List<Node> arrTree[];
	private static int resultDiameter;
	
	private static void dfs(int idx, int dia) {
		isVisit[idx] = true;
		for(Node node : arrTree[idx]) {
			if(isVisit[node.idx] == false) dfs(node.idx, dia + node.weight);
		}
		resultDiameter = resultDiameter > dia ? resultDiameter : dia;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		arrTree = new ArrayList[num + 1];
		for(int i = 1; i < num + 1; i++) {
			arrTree[i] = new ArrayList<Node>();
		}

		String[] treeInfo = new String[3];
		for(int i = 0; i < num - 1; i++) {
			treeInfo = br.readLine().split(" ");
			int parent = Integer.valueOf(treeInfo[0]);
			int child = Integer.valueOf(treeInfo[1]);
			int weight = Integer.valueOf(treeInfo[2]);
			
			arrTree[parent].add(new Node(child, weight));
			arrTree[child].add(new Node(parent, weight));
		}

		resultDiameter = 0;
		for(int i = 1; i < num+1; i++) {
			isVisit = new boolean[num + 1];
			dfs(i, 0);
		}
		
		System.out.println(resultDiameter);
	}
	
	private static class Node{
		int idx;
		int weight;
		
		private Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}
}
