/*
    Link : https://www.acmicpc.net/problem/10844
    Question : 이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다. N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.
    Description : 이 문제는 동적 프로그래밍을 활용한 문제로, TopDown 방식은 시간 초과의 문제가 있다. 그래서 BottomUp 방식으로 대체.

    ※ dp[i][j]
    - i : 자릿수
    - j : 숫자
    - dp[i][j] : i 자릿수에 j라는 수가 있는 총 개수

    ex) dp[3][5] => XX5 (345, 765, ...)
*/
package StairCnt_10844;

import java.util.Scanner;

public class Main {
    static int N;
    static long mod = 1000000000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long dp[][] = new long[N+1][10];

        for(int i=1; i<10; i++) {
            dp[1][i] = 1;
        }

        //   - 중간에 나머지 계산을 해주는 이유
        //   : 점화식을 통해 합을 계산하는 경우에도, type 범위를 초과해서 원치 않는 값을 배열에 저장하는 경우가 발생하기 때문 (ex, 범위를 초과하여 음수 값이나 쓰레기 값이 저장됨)
        for(int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++) {
                long add = 0;

                if(j + 1 <= 9) add += dp[i - 1][j + 1];
                if(j - 1 >= 0) add += dp[i - 1][j - 1];

                dp[i][j] = add % mod;
            }
        }

        long ans = 0;
        for(int i=0; i<10; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % mod);
    }

}
