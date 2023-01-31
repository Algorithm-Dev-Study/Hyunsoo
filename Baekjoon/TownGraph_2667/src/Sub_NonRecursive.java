/*
	Link : https://www.acmicpc.net/problem/2667
	Algorithm Link : https://docs.google.com/spreadsheets/d/1YJNIXZHFCm2wEjcbrh3bkV9u9HfygImS/edit#gid=1111337058
	Question : 단지수와 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하라.

	※ 재귀 없는 반복문 사용
*/
package TownGraph_2667;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Sub_NonRecursive {
    private static int num;
    private static int step;        // 지나온 거리, Stack의 index
    private static int[][] path;    // 지나온 좌표
    private static int[][] matrix;  // 입력 받은 단지 정보
    private static int[][] apt;     // 아파트에 단지 번호 매기기 위함
    private static int aptNum;      // 단지 수
    private static int aptCnt;      // 단지 내 아파트 개수

    private static void searchConnected(int row, int col) {
        path = new int[num*num+1][2];
        step = 1;

        path[step][0] = row; // 시작점 행
        path[step][1] = col; // 시작점 열
        apt[row][col] = aptNum;   // 단지번호 기록
        aptCnt = 1;

        while(step > 0) {
            if(row-1 >= 0 && matrix[row-1][col] == 1 && apt[row-1][col] == 0) {   // 12시 방향
                recordConnected(row-1, col);
                row--;
            } else if(col+1 < num && matrix[row][col+1] == 1 && apt[row][col+1] == 0) {   // 3시 방향
                recordConnected(row, col+1);
                col++;
            } else if(row+1 < num && matrix[row+1][col] == 1 && apt[row+1][col] == 0) {   // 6시 방향
                recordConnected(row+1, col);
                row++;
            } else if(col-1 >= 0 && matrix[row][col-1] == 1 && apt[row][col-1] == 0) {   // 9시 방향
                recordConnected(row, col-1);
                col--;
            } else {
                step--;
                row = path[step][0];
                col = path[step][1];
            }
        }
    }

    private static void recordConnected (int row, int col) {
        step++;
        aptCnt++;
        path[step][0] = row;
        path[step][1] = col;
        apt[row][col] = aptNum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());
        apt = new int[num][num];
        matrix = new int[num][num];

        for(int i = 0; i < num; i++) {
            String graph = br.readLine();
            for(int j = 0; j < num; j++) {
                matrix[i][j] = graph.charAt(j) - '0';
                apt[i][j] = 0;
            }
        }

        aptNum = 1;
        ArrayList<Integer> arrAptCnt = new ArrayList<>();
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                if(matrix[i][j] == 1 && apt[i][j] == 0) {
                    searchConnected(i, j);
                    arrAptCnt.add(aptCnt);
                    aptNum++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(aptNum-1 + "\n");
        if(arrAptCnt.size() > 0) {
            Collections.sort(arrAptCnt);
            for(int cnt : arrAptCnt) {
                sb.append(cnt + "\n");
            }
        }
        System.out.println(sb);
    }
}
