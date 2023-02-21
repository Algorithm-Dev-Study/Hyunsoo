/*
 * Link : https://www.acmicpc.net/problem/13459
 * Question : 파란 구슬을 구멍에 넣지 않으면서 빨간 구슬을 10번 이하로 움직여서 빼낼 수 있으면 1을 없으면 0을 출력한다.
 * Solution :
 * Description :
 */
package MarbleEscape_13459;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String matrix[][];
    private static int moveMarble() {


        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.valueOf(inputs[0]);
        int M = Integer.valueOf(inputs[1]);
        matrix = new String[N][M];

        String[] matrixInputs;
        int redRow, redCol, blueRow, blueCol;
        for(int i = 0; i < N; i++) {
            matrixInputs = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                matrix[i][j] = matrixInputs[j];
                if(matrixInputs[j] == "R"){
                    redRow = i;
                    redCol = j;
                } else if(matrixInputs[j] == "B") {
                    blueRow = i;
                    blueCol = j;
                }
            }
        }



    }
}
