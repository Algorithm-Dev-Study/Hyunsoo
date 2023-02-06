/*
* Link : https://www.acmicpc.net/problem/10830
* Question : 크기가 N*N인 행렬 A가 주어진다. 이때, A의 B제곱을 구하는 프로그램을 작성하시오. 수가 매우 커질 수 있으니, A^B의 각 원소를 1,000으로 나눈 나머지를 출력한다.
* Solution : 분할과 정복에 행렬 곱을 적용.
* Description : 중간에 쓰레기 값을 주의!!
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int matrix[][];

    private static int[][] multiMatrix(int[][] a, int[][] b) {
        int matrixAnswer[][] = new int[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++) {
                for(int k = 0; k < a[0].length; k++) {
                    matrixAnswer[i][j] += a[i][k] * b[k][j] % 1000;
                }
            }
        }
        return matrixAnswer;
    }

    private static int[][] powMatrix(int[][] a, long cnt) {
        if(cnt == 1) return a;

        a = powMatrix(a, cnt / 2);

        if(cnt % 2 == 0) return multiMatrix(a, a);
        else return multiMatrix(multiMatrix(a, a), matrix);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputVals = br.readLine().split(" ");
        int matrixN = Integer.valueOf(inputVals[0]);
        long multipleN = Long.valueOf(inputVals[1]);

        matrix = new int[matrixN][matrixN];
        for(int i = 0; i < matrixN; i++){
            String[] vals = br.readLine().split(" ");
            for(int j = 0; j < matrixN; j++) {
                matrix[i][j] = Integer.valueOf(vals[j]);
            }
        }

        int answer[][] = powMatrix(matrix, multipleN);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrixN; i++){
            for(int j = 0; j < matrixN; j++) {
                answer[i][j] %= 1000;
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
