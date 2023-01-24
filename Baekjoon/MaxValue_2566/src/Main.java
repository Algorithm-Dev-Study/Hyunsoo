
/*
	Link : https://www.acmicpc.net/problem/2566
	Description : 9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] matrix = new int[9][9];
		String[] text;
		for(int i = 0; i < 9; i++) {
			text = br.readLine().split(" ");
			for(int j = 0; j < 9; j++) {
				matrix[i][j] = Integer.valueOf(text[j]);
			}
		}
		
		int col = 0, row = 0, max = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(matrix[i][j] > max) {
					max = matrix[i][j];
					row = i;
					col = j;
				}
			}
		}
		
		System.out.println(max);
		System.out.println((row + 1) + " " + (col + 1));
		
	}
}
