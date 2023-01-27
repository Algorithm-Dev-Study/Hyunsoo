/*
    - 메모리 초과
    - Reason : 메모리 초과를 예상하여 Queue를 사용하였지만, Queue 너무 많이 사용함..
    - Solution : use 'StringBuilder'
*/
package StringBomb_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Sub_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strText = br.readLine();
        String strBomb = br.readLine();

        if(strText.contains(strBomb)) {
            Queue<Character> queueText = new LinkedList<>();
            for (int i = 0; i < strText.length(); i++) {
                queueText.add(strText.charAt(i));
            }

            int idxBomb;
            boolean isFinish = false;
            Queue<Character> queueTmp = new LinkedList<>();
            Queue<Character> queueTmpNotEqual = new LinkedList<>();
            while(queueText.size() != 0 && !isFinish) {
                idxBomb = 0;
                while (true) {
                    if (queueText.peek() == strBomb.charAt(idxBomb)) {
                        queueTmp.offer(queueText.poll());
                        if(idxBomb == strBomb.length() - 1) {
                            queueTmp.clear();
                            if(!queueTmpNotEqual.isEmpty()) {
                                queueTmpNotEqual.addAll(queueText);
                                queueText.clear();
                                queueText.addAll(queueTmpNotEqual);
                                queueTmpNotEqual.clear();
                            }
                            break;
                        }
                        idxBomb++;
                    } else if (queueTmp.size() > 0) {
                        queueTmpNotEqual.addAll(queueTmp);
                        queueTmp.clear();
                        break;
                    } else {
                        queueTmpNotEqual.offer(queueText.poll());
                    }

                    // finish condition
                    if (queueText.size() <= 0) {
                        if(!queueTmpNotEqual.isEmpty()) queueText.addAll(queueTmpNotEqual);
                        isFinish = true;
                        break;
                    }
                }
            }

            if(queueText.size() == 0) {
                System.out.println("FRULA");
            } else {
                StringBuilder sb = new StringBuilder();
                while(!queueText.isEmpty()) {
                    sb.append(queueText.poll());
                }
                System.out.println(sb);
            }
        } else {
            System.out.println(strText);
        }
    }
}
