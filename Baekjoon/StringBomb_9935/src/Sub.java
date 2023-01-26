/*
    - 메모리 초과
    - Reason : 메모리 초과를 예상하여 Stack을 사용하였지만, Stack 너무 많이 사용함..
    - Solution : use 'StringBuilder'
*/
package StringBomb_9935;

import java.io.*;
import java.util.Stack;

public class Sub {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strText = br.readLine();
        String strBomb = br.readLine();

        if(strText.contains(strBomb)) {
            Stack<Character> stackText = new Stack<>();
            Stack<Character> stackBomb = new Stack<>();
            for (int i = 0; i < strText.length(); i++) {
                stackText.push(strText.charAt(i));
            }
            for (int i = 0; i < strBomb.length(); i++) {
                stackBomb.push(strBomb.charAt(i));
            }
            Stack<Character> stackTmp = (Stack<Character>) stackText.clone();
            Stack<Character> stackTmpBomb = (Stack<Character>) stackBomb.clone();

            int idx = 0;
            boolean isFinish = false;
            while(stackText.size() != 0 && !isFinish) {
                while (idx < stackText.size()) {
                    if (stackText.elementAt(idx) == stackTmpBomb.elementAt(0)) {
                        if(stackTmpBomb.size() > 0) {
                            stackText.remove(idx);
                            stackTmpBomb.remove(0);
                            if (stackTmpBomb.size() == 0) {
                                stackTmp = (Stack<Character>) stackText.clone();
                                stackTmpBomb = (Stack<Character>) stackBomb.clone();
                                idx = 0;
                                break;
                            }
                            continue;
                        }
                    } else if (stackTmpBomb.size() != stackBomb.size()) {
                        stackText = (Stack<Character>) stackTmp.clone();
                        stackTmpBomb = (Stack<Character>) stackBomb.clone();
                        idx++;
                        break;
                    }

                    // finish condition
                    if(idx == stackText.size() - 1 && stackTmpBomb.size() == stackBomb.size()) {
                        isFinish = true;
                        break;
                    }

                    idx++;
                }
            }

            if(stackText.size() == 0) {
                System.out.println("FRULA");
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < stackText.size(); i++) {
                    sb.append(stackText.elementAt(i));
                }
                System.out.println(sb);
            }
        }
    }
}
