package ShortestPath_1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Sub2 {
    private static int startNum;
    private static ArrayList<Integer> before;
    private static ArrayList<Integer> after;
    private static int[] dist;
    private static Map<Integer, ArrayList> graph;
    private static int totalVal;
    private static int shortestVal;

    private static void calcShortestPath(int start, int destination) {
       /* if(start == destination) {
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
        }*/
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int vNum = Integer.parseInt(input[0]);  // 정점의 개수
        int eNum = Integer.parseInt(input[1]);  // 간선의 개수

        startNum = Integer.parseInt(br.readLine()); // 시작점

        graph = new HashMap<>();
        ArrayList<Integer[]> q;
        Integer[] lst;
        for(int i = 0; i < eNum; i++) {
            input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            lst = new Integer[2];
            lst[0] = e;
            lst[1] = w;

            q = (graph.get(v) == null) ? new ArrayList<>() : graph.get(v);
            q.add(lst);
            graph.put(v, q);
        }

        // 초기화
        dist = new int[vNum];
        after = new ArrayList<>();
        before = new ArrayList<>();
        for(int i = 1; i < vNum+1; i++) {
            dist[i] = 0;
            before.add(i);
        }

        // 각 노드 당 최단 거리 구하기
        StringBuilder sb = new StringBuilder();
        String result;
        while(before.size() > 0) {
            after.add(startNum);
            before.remove(before.indexOf(startNum));
            ArrayList<Integer[]> arrlst = graph.get(startNum);
            for(Integer[] nodeInfo : arrlst) {
                if(dist[nodeInfo[0]] > nodeInfo[1]) dist[nodeInfo[0]] = nodeInfo[1];    // 갱신
            }
            startNum = before.get(0);
        }

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
