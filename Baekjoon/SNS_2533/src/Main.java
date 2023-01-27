/*
 * -Date : 2023-01-27
 * -Author : myhuon3321@gmail.com
 * -Link : https://www.acmicpc.net/problem/2533
 * -Question : 친구 관계 트리가 주어졌을 때, 모든 개인이 새로운 아이디어를 수용하기 위하여 필요한 최소 얼리 어답터의 수를 구하는 프로그램을 작성하시오.
 * -Description : 경로 존재, 사이클 X
 * -Caution () :
 * -Solution :
 */
package SNS_2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        Node dp[] = new Node[N+1];  // dp[node no.] = node info

        for(int i = 0; i < N+1; i++) {
            dp[i] = new Node(0, 0);
        }

        for(int i = 1; i < N; i++) {
            String[] nodes = br.readLine().split(" ");

            if(dp[Integer.parseInt(nodes[0])].childNo == null) dp[Integer.parseInt(nodes[0])].childNo = new ArrayList<>();
            dp[Integer.parseInt(nodes[0])].childNo.add(Integer.parseInt(nodes[1]));
            dp[Integer.parseInt(nodes[1])].parentNo = Integer.parseInt(nodes[0]);
        }

        int ans = 0;
        boolean isAdd;
        for(int i = 2; i <= N; i++) {
            System.out.println("dp[i].nodeNo : " + i);
            System.out.println("dp[i].parentNo : " + dp[i].parentNo);
            System.out.println("dp[i].childNo : " + dp[i].childNo);
            System.out.println("dp[i].isEarlyAdopter before: " + dp[i].isEarlyAdopter);
            isAdd = false;
            if(dp[dp[i].parentNo].isEarlyAdopter == 0) {
                isAdd = true;
            } else if(dp[i].childNo != null) {
                isAdd = true;
            }

            if(isAdd) {
                dp[i].isEarlyAdopter = 1;
                ans++;
            }
            System.out.println("dp[i].isEarlyAdopter after: " + dp[i].isEarlyAdopter);
            System.out.println("***********************************************");
        }

        System.out.println(ans);
    }


    public static class Node{
        int nodeNo;
        int parentNo;
        ArrayList<Integer> childNo;
        int isEarlyAdopter;

        public Node(int nodeNo, int isEarlyAdopter) {
            this.nodeNo = nodeNo;
            this.isEarlyAdopter = isEarlyAdopter;
        }
    }
}
