/*
    - Link : https://www.acmicpc.net/problem/5397
    - Question : 강산이가 비밀번호 창에서 입력한 키가 주어졌을 때, 강산이의 비밀번호를 알아내는 프로그램을 작성.
    - Description :'<' -> 왼쪽 스택에서 오른쪽 스택으로 이동, '>' -> 오른쪽 스택에서 왼쪽 스택으로 이동, '-' -> 커서 앞 글자 지우기.

    - Caution (time over)
    1. 문자열 이어붙이기의 경우 '+' 보다 StringBuilder 사용.
    2. Scanner, System.out.println 보다 BufferedReader, BufferedWriter 사용.
       • BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); br.readLine();
       • BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); bw.write(s + "\n");

       ※ 버퍼 지우고 닫기 필수
       : bw.flush(); bw.close();
*/
import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < num; i++) {
            String strText = br.readLine();

            Stack<Character> lStack = new Stack<>();
            Stack<Character> rStack = new Stack<>();
            for(int j = 0; j < strText.length(); j++) {
                char cKey = strText.charAt(j);
                if(cKey == '<') {
                    if(!lStack.empty()) rStack.push(lStack.pop());
                } else if (cKey == '>') {
                    if(!rStack.empty()) lStack.push(rStack.pop());
                } else if (cKey == '-') {
                    if(!lStack.empty()) lStack.pop();
                } else {
                    lStack.push(cKey);
                }
            }

            if(!rStack.empty()) {
                while(!rStack.empty()) {
                    lStack.push(rStack.pop());
                }
            }

            StringBuilder answer = new StringBuilder();
            /*while(!lStack.empty()) {
                answer.append(lStack.remove(0));
            }*/
            for(int k = 0; k < lStack.size(); k++) {
                answer.append(lStack.elementAt(k));
            }

            bw.write(answer+"\n");
        }

        bw.flush();
        bw.close();
    }
}
