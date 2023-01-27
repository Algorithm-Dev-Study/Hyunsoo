/*
    - 성공
    - Description : StringBuilder보다 메모리와 시간이 두 배 정도 더 소요됨
*/
package StringBomb_9935;

import java.io.*;
import java.util.Stack;

public class Sub_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strText = br.readLine();
        String strBomb = br.readLine();

        if(strText.contains(strBomb)) {
            Stack<Character> stackText = new Stack<>();
            for(int i = 0; i < strText.length(); i++) {
                stackText.push(strText.charAt(i));
                if(stackText.size() >= strBomb.length()){
                    boolean isMatched = true;
                    for(int j = 0; j < strBomb.length(); j++) {
                        if(stackText.elementAt(stackText.size() - strBomb.length() + j) != strBomb.charAt(j)) {
                            isMatched = false;
                            break;
                        }
                    }
                    if(isMatched) {
                        for(int k = 0; k < strBomb.length(); k++) {
                            stackText.pop();
                        }
                    }
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
        } else {
            System.out.println(strText);
        }
    }
}
