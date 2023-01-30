/*
    Link : https://www.acmicpc.net/problem/2533
    Question : 친구 관계 트리가 주어졌을 때, 모든 개인이 새로운 아이디어를 수용하기 위하여 필요한 최소 얼리 어답터의 수를 구하는 프로그램을 작성하시오.
    Description : 이 문제는 동적 프로그래밍을 활용한 문제로, TopDown 방식을 사용함. (양방향 트리구조)

    ※ 문제에 입력 예시의 첫 번째 줄의 노드가 부모 노드라는 명시가 없기 때문에, 내 마음대로 첫 번째 줄이 부모 노드일거라는 생각하지 않기! (=> 단방향 트리 → 양방향 트리)
*/
package SNS_2533;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    private static int N;
    private static Node[] dp;

    public static void dfs(int idx) {
        dp[idx].isVisited = true;
        dp[idx].isEarlyAdopter[0] = 0;
        dp[idx].isEarlyAdopter[1] = 1;

        if(dp[idx].linkedNode != null) {
            for(int child : dp[idx].linkedNode) {
                if(!dp[child].isVisited) {
                    dfs(child);
                    dp[idx].isEarlyAdopter[0] += dp[child].isEarlyAdopter[1];   // 자신이 얼리 어답터가 아니라면, 자식 노드는 무조건 얼리 어답터여야함.
                    dp[idx].isEarlyAdopter[1] += Math.min(dp[child].isEarlyAdopter[0], dp[child].isEarlyAdopter[1]);    // 자신이 얼리 어답터라면, 자식 노드는 얼리 어답터일수도 아닐수도 있음.
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        dp = new Node[N+1];  // dp[node no.] = node info

        for(int i = 1; i < N+1; i++) {
            dp[i] = new Node();
            dp[i].isVisited = false;
        }

        for(int i = 1; i < N; i++) {
            String[] nodes = br.readLine().split(" ");
            int start = Integer.parseInt(nodes[0]);
            int end = Integer.parseInt(nodes[1]);

            if(dp[start].linkedNode == null) dp[start].linkedNode = new ArrayList<>();
            dp[start].linkedNode.add(end);

            if(dp[end].linkedNode == null) dp[end].linkedNode = new ArrayList<>();
            dp[end].linkedNode.add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1].isEarlyAdopter[0], dp[1].isEarlyAdopter[1]));
    }


    public static class Node{
        ArrayList<Integer> linkedNode;
        int[] isEarlyAdopter = new int[2];
        boolean isVisited;
    }
}
