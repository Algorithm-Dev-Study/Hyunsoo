/*
    - 메모리 초과
    - Reason : String이나 배열 중간에 CRUD 할 경우 메모리 초과될 가능성 매우 높음.
    - Solution : use 'Stack' or 'StringBuilder'
*/
package StringBomb_9935;

import java.io.*;

public class Sub_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strText = br.readLine();
        String strBomb = br.readLine();

        while(strText.contains(strBomb)) {
            for(int i = 0; i < strText.length(); i++) {
                if(strText.length() >= i + strBomb.length() && strText.substring(i, i + strBomb.length()).equals(strBomb)) {
                    strText = strText.substring(0, i) + strText.substring(i + strBomb.length());
                    break;
                }
            }
        }

        if(strText.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(strText);
        }
    }
}
