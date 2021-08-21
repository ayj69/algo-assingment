package algoass;

import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String args[]) {
	ArrayList<Integer> is = new ArrayList<Integer>();
	
	System.out.println(Algo.autoGenInt(0, 10));

	for (int i = 0;i < 5 ;i++) {
		is.add(Algo.autoGenInt(0, 10));
	}
	for (int i = 0;i < 10 ;i++) {
		is.add(Algo.autoGenInt(0, 10/4));
	}
		
		System.out.println(is.toString());
		nextFit(10,15,is);
		
	}
	
	
	public static <E extends Number & Comparable<E>> void nextFit(int binsize,int itemnumber,ArrayList<Integer> is) {
		
		ArrayList<ArrayList<Integer>> lol = new ArrayList<ArrayList<Integer>>();
		lol.add(new ArrayList<Integer>());
		int i = 0;
		int j = 0;
		while(j<itemnumber) {
			if (checkValid(calSum(lol.get(i)) + is.get(j).intValue(),binsize)) {
				lol.get(i).add(is.get(j));
				j++;
			}else {
				lol.add(new ArrayList<Integer>());
				i++;
			}
		}
		
		System.out.println(lol.toString());
	}
	
	
	public static <E extends Number> int calSum(List<E> list) {
		int total = 0;
		for(int i = 0;i < list.size();i++) {
			total += list.get(i).intValue();
			}
		return total;
	}
	
	public static <E extends Comparable<E>> boolean checkValid(E sum,E binsize) {
		if (sum.compareTo(binsize) > 0) {
			return false;
		}else {
			return true;
		}
	}
	

}
