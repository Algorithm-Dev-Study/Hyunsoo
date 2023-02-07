/*
    - Link : https://www.acmicpc.net/problem/9935
    - Question : 특정 문자열이 문자열에 존재하면 문자열에서 특정 문자열이 사라지며, 남은 문자열은 합쳐지게 된다. 남아있는 문자가 없는 경우, "FRULA"를 출력한다.
    - Description : 메모리 초과 주의
    - Caution (memory over) : String이나 배열 중간에 CRUD 할 경우 메모리 초과될 가능성 매우 높음.
    - Solution : use 'Stack' or 'StringBuilder'

*/
package StringBomb_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strText = br.readLine();
        String strBomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strText.length(); i++) {
            sb.append(strText.charAt(i));
            if(sb.length() >= strBomb.length()){
                boolean isMatched = true;
                for(int j = 0; j < strBomb.length(); j++) {
                    if(sb.charAt(sb.length() - strBomb.length() + j) != strBomb.charAt(j)) {
                        isMatched = false;
                        break;
                    }
                }
                if(isMatched) {
                    sb.delete(sb.length() - strBomb.length(), sb.length());
                }
            }
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
