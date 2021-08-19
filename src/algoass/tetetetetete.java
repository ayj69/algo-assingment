package algoass;

import java.util.ArrayList;

public class tetetetetete {
	
	
	public static void main(String args[]) {
		ArrayList<Integer> arrint = new ArrayList<Integer>();
		
		for (int i = 0;i < 5;i++) {
			arrint.add((int)((Math.random())*100)+1);
		}
		for (int i = 0;i < 10;i++) {
			arrint.add((int)((Math.random())*10)+1);
		}
		
		System.out.println(arrint.toString());
		System.out.println(	calSum(arrint));
		
	}
	
	
	public static int calSum(ArrayList<Integer> list) {
		int total = 0;
		for(int i = 0;i < list.size();i++) {
			total += list.get(i);
			}
		return total;
	}
}
