/*
 * 백준 시간초과 해결
 * 1. 메소드 통합
 * 2. Scanner -> BufferedReader 변경 
 * 
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Stack_v2 {
	static ArrayList<Integer> listStack = new ArrayList<>();
	static int stackSize = 0;
	
	private static int doAction(String[] arrInput) {
		int result = -2;
		
		switch(arrInput[0]) {
		case "pop" :
			if(stackSize == 0) {
				result = -1;
			} else {
				result = listStack.remove(stackSize - 1);
				stackSize--;
			}
			break;
		case "push" :
			listStack.add(Integer.valueOf(arrInput[1]));
			stackSize++;
			break;
		case "size" :
			result = stackSize;
			break;
		case "empty" :
			if(stackSize == 0) result = 1;
			else result = 0;
			break;
		case "top" :
			if(stackSize == 0) result = -1;
			else result = listStack.get(stackSize - 1);
			break;			
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(br.readLine());
		
		String strInput = "";
		int result = 0;
		String[] arrInput = new String[2];
		for(int i = 0; i < num; i++) {
			strInput = br.readLine();
			arrInput = strInput.split(" ");
			result = doAction(arrInput);
			if (result != -2) System.out.println(result);
		}
	}
}
