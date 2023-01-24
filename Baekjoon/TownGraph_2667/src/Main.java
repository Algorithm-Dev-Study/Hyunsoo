
/*
	Link : https://www.acmicpc.net/problem/2667
	Description : 단지수와 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하라.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	private static int list[][];
	private static boolean isVisit[][];
	private static int numTown;
	private static ArrayList<Integer> numHouse;
	private static int num;
	
	private static void calc(int col, int row) {
		isVisit[col][row] = true;
		numTown++;
		if(col + 1 < num && list[col + 1][row] == 1 && isVisit[col + 1][row] == false) {
			calc(col + 1, row);
		}
		if(row + 1 < num && list[col][row + 1] == 1 && isVisit[col][row + 1] == false) {
			calc(col, row + 1);
		}
		if(col - 1 >= 0 && list[col - 1][row] == 1 && isVisit[col - 1][row] == false) {
			calc(col - 1, row);
		}
		if(row - 1 >= 0 && list[col][row - 1] == 1 && isVisit[col][row - 1] == false) {
			calc(col, row - 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		
		list = new int[num][num];
		isVisit = new boolean[num][num];
		for(int i = 0; i < num; i++) {
			String graph = br.readLine();
			for(int j = 0; j < num; j++) {
				list[i][j] = graph.charAt(j) - '0';
				isVisit[i][j] = false;
			}
		}
		
		numHouse = new ArrayList<Integer>();
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				if(list[i][j] == 1 && isVisit[i][j] != true) {
					numTown = 0;
					calc(i, j);
					numHouse.add(numTown);
				}
			}
		}
		
		System.out.println(numHouse.size());
		Collections.sort(numHouse);
		for(Integer houseCnt : numHouse) {
			System.out.println(houseCnt);
		}
	}
}
