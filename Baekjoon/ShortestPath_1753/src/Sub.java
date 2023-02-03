package ShortestPath_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Sub {
    private static int startNum;
    private static Map<Integer, Queue> graph;
    private static int totalVal;
    private static int shortestVal;

    private static void calcShortestPath(int start, int destination) {
        if(start == destination) {
            shortestVal = shortestVal > 0 ? Math.min(totalVal, shortestVal) : totalVal;
            return;
        }

        Queue<Integer[]> listNode = graph.get(start);
        if(listNode != null) {
            for(Integer[] node : listNode){
                totalVal += node[1];
                calcShortestPath(node[0], destination);
                totalVal -= node[1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int vNum = Integer.parseInt(input[0]);  // 정점의 개수
        int eNum = Integer.parseInt(input[1]);  // 간선의 개수

        startNum = Integer.parseInt(br.readLine()); // 시작점

        graph = new HashMap<>();
        Queue<Integer[]> q;
        Integer[] lst;
        for(int i = 0; i < eNum; i++) {
            input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            lst = new Integer[2];
            lst[0] = e;
            lst[1] = w;

            q = (graph.get(v) == null) ? new LinkedList<>() : graph.get(v);
            q.add(lst);
            graph.put(v, q);
        }

        StringBuilder sb = new StringBuilder();
        String result;
        for(int i = 1; i < vNum+1; i++) {
            if(startNum != i) {
                totalVal = 0;
                shortestVal = 0;
                calcShortestPath(startNum, i);
                result = shortestVal > 0 ? String.valueOf(shortestVal) : "INF";
            } else {
                result = "0";
            }
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
