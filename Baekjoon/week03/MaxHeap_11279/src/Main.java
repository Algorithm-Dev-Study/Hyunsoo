/*
* Link : https://www.acmicpc.net/problem/11279
* Question : 입력에서 0이 주어진 회수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다.
* Description : 우선순위 큐 + 힙
*   - 최대힙
*   1. PriorityQueue(Collections.reverseOrder())
*   2. PriorityQueue(Comparator 클래스);
*       2-1. o1 < o2 -> 1, o1 > o2 -> -1, 0
*/
package MaxHeap_11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        sortCls compareCls = new sortCls();
        PriorityQueue<Long> pq = new PriorityQueue<>(compareCls); //Collections.reverseOrder()

        StringBuilder sb = new StringBuilder();
        long num, answer;
        for(int i = 0; i < n; i++){
            num = Long.valueOf(br.readLine());
            if(num != 0) {
                pq.add(num);
            } else {
                answer = pq.size() > 0 ? pq.poll() : 0;
                sb.append(answer + "\n");
            }
        }
        System.out.println(sb);
    }

    private static class sortCls implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            Long num1 = (Long) o1;
            Long num2 = (Long) o2;

            if (num1 < num2) return 1;
            else if (num1 > num2) return -1;
            else return 0;
        }
    }
}
