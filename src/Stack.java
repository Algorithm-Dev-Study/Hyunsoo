/*
 * 백준 시간초과 해결 -> Stack_v2
 * 
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Stack {
	static ArrayList<Integer> listStack = new ArrayList<>();
	static int stackSize = 0;
	
	private static int pop () {
		if(stackSize == 0) return -1;
		return listStack.remove(stackSize - 1);
	}
	
	private static void push(int num) {
		listStack.add(num);
	}
	
	private static int isEmpty() {
		if(stackSize == 0) return 1;
		return 0;
	}
	
	private static int getTop() {
		if(stackSize == 0) return -1;
		return listStack.get(stackSize - 1);
	}
	
	private static int doAction(String[] arrInput) {
		int result = -2;
		
		switch(arrInput[0]) {
		case "pop" :
			result = pop();
			if(result != -1) stackSize--;
			break;
		case "push" :
			push(Integer.valueOf(arrInput[1]));
			stackSize++;
			break;
		case "size" :
			result = stackSize;
			break;
		case "empty" :
			result = isEmpty();
			break;
		case "top" :
			result = getTop();
			break;			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		String strInput = "";
		int result = 0;
		String[] arrInput = new String[2];
		for(int i = 0; i < num; i++) {
			strInput = sc.nextLine();
			arrInput = strInput.split(" ");
			result = doAction(arrInput);
			if (result != -2) System.out.println(result);
		}
		
		sc.close();
	}
}
