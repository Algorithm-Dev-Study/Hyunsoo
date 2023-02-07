/*
* Link : https://www.acmicpc.net/problem/11444
* Question : n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.
* Solution : n의 크기가 크기 때문에 동적프로그래밍과 분할 정복만으로는 시간 초과가 난다. -> Fibonacci를 행렬로 만들어 수식을 찾는다.
*            ※ [Fn+1, Fn] = [[1,1], [1,0]]^n * [1,0]
* Reference Link : https://st-lab.tistory.com/252
*/
package Fibo6_11444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static long[][] C = {{1, 1}, {1, 0}};
    private static long[][] Fn = {{1}, {0}};
    private static long mod = 1000000007;

    private static long[][] matrixPow(long[][] matrix, long n) {
        if(n == 1) return matrix;

        matrix = matrixPow(matrix, n / 2);

        if(n % 2 == 0) return matrixMultiple(matrix, matrix);
        else return matrixMultiple(matrixMultiple(matrix, matrix), C);
    }

    private static long[][] matrixMultiple(long[][] a, long[][] b) {
        long[][] returnMatrix = new long[a.length][b[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < b[0].length; j++) {
                for(int k = 0; k < a[1].length; k++) {
                    returnMatrix[i][j] += a[i][k] * b[k][j] % mod;
                }
            }
        }
        return returnMatrix;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.valueOf(br.readLine());

        long powVal[][] = matrixPow(C, n);
        long result[][] = matrixMultiple(powVal, Fn);
        System.out.println(result[1][0] % mod);
    }
}
