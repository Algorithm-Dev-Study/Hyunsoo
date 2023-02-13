package ShortestPath_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int vNum = Integer.parseInt(input[0]);  // 정점의 개수
        int eNum = Integer.parseInt(input[1]);  // 간선의 개수

        int startNum = Integer.parseInt(br.readLine()); // 시작점

        List<Node> graph[] = new ArrayList[vNum+1];
        int v, e, w;
        for(int i = 0; i < eNum; i++) {
            input = br.readLine().split(" ");
            v = Integer.parseInt(input[0]);
            e = Integer.parseInt(input[1]);
            w = Integer.parseInt(input[2]);
            if(graph[v] == null) graph[v] = new ArrayList<>();
            graph[v].add(new Node(e, w));
        }

        int[] result = new int[vNum+1];
        Arrays.fill(result, INF);
        result[startNum] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNum, 0));

        Node flgNode;
        while(!pq.isEmpty()) {
            flgNode = pq.poll();

            if(flgNode.weight > result[flgNode.nodeIdx]) continue;

            if(graph[flgNode.nodeIdx] != null) {
                for(Node node : graph[flgNode.nodeIdx]){
                    int current = result[node.nodeIdx];
                    int calc = result[flgNode.nodeIdx] + node.weight;
                    if(current > calc) {
                        result[node.nodeIdx] = calc;
                        pq.add(new Node(node.nodeIdx, result[node.nodeIdx]));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        String answer;
        for(int i = 1; i < vNum+1; i++) {
            answer = result[i] != INF ? String.valueOf(result[i]) : "INF";
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }

    private static class Node implements Comparable<Node>{
        int nodeIdx;
        int weight;

        private Node(int linkedNode, int weight) {
            this.nodeIdx = linkedNode;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
