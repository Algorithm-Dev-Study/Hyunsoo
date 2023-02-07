/*
 Link : https://www.acmicpc.net/problem/4949
 Description : 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static String isBalance(String str) {
		ArrayList<Character> opp = new ArrayList<Character>();
		int oppSize = 0;
		for(int i = 0; i < str.length(); i++) {
			oppSize = opp.size();
			char c = str.charAt(i);
			if(c == '(' || c == '[') {
				opp.add(c);
			} else if(c == ')') {
				if(oppSize == 0 || opp.remove(oppSize - 1) != '(') {
					return "no";
				}
			} else if(c == ']') {
				if(oppSize == 0 || opp.remove(oppSize - 1) != '[') {
					return "no";
				}
			}
		}
		if(oppSize == 0) return "yes";
		else return "no";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String text = "";
		while(true) {
			text = br.readLine();
			if(text.equals(".")) break;
			System.out.println(isBalance(text));
		}
	}
}
