/*
* Link : https://www.acmicpc.net/problem/11047
* Question : 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
* Solution : 나눌 수 있는 가장 큰 수를 찾는다.
* Description : Greedy 알고리즘
*/
package Coin0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.valueOf(input[0]);
        long K = Long.valueOf(input[1]);

        long moneys[] = new long[N+1];
        for(int i = 1; i < N+1; i++) {
            moneys[i] = Long.valueOf(br.readLine());
        }

        String[] strK = input[1].split("");
        int len = strK.length;

        int divNum;
        if(N >= len * 2) {
            if(Long.valueOf(strK[0]) >= 5) divNum = len * 2;
            else divNum = len * 2 - 1;
        } else {
            divNum = N;
        }

        int cnt = 0;
        long divMoney = moneys[divNum];
        while(K > 0){
            cnt += K / divMoney;
            K %= divMoney;
            divMoney = moneys[--divNum];
        }

        System.out.println(cnt);
    }
}
