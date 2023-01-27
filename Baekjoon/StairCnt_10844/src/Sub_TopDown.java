/*
    - Result : Fail
    - Reason : Time Over
*/
package StairCnt_10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Sub_TopDown {
    private static int N;
    private static int mod = 1000000000;
    private static int cnt = 0;
    private static void calc(Stack<Integer> st) {
        if(st.size() >= N) {
            cnt++;
            return ;
        }
        if(st.peek() > 0) {
            st.push(st.peek() - 1);
            calc(st);
            st.pop();
        }
        if(st.peek() < 9) {
            st.push(st.peek() + 1);
            calc(st);
            st.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 9; i++) {
            stack.push(i);
            calc(stack);
            stack.pop();
        }

        if(cnt != 0) {
            System.out.println(cnt % mod);
        }
    }
}
