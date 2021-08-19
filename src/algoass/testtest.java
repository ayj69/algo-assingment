package algoass;

import java.util.ArrayList;


public class testtest {
	public static void main(String atgs[]) {
		
		ArrayList<Integer> intarr = new ArrayList<Integer>();
		for (int i = 0;i < 5;i++) {
			intarr.add((int)((Math.random())*100)+1);
		}
		for (int i = 0;i < 10;i++) {
			intarr.add((int)((Math.random())*10)+1);
		}
		int binsize = 100;
		int itemnum = intarr.size();
		System.out.println(itemnum);
		nextInt(binsize,itemnum,intarr);
		
		
		
		
		
		
	}
	public static <E extends Number> void nextInt(int binsize,int itemnumber,ArrayList<E> aaa) {
	
		ArrayList<ArrayList<E>> lol = new ArrayList<ArrayList<E>>();
		lol.add(new ArrayList<E>());
		int i = 0;
		int j = 0;
		while(j<itemnumber) {
			if (checkValid(calSum(lol.get(i)) + aaa.get(j).intValue(),binsize)) {
				lol.get(i).add(aaa.get(j));
				j++;
			}else {
				lol.add(new ArrayList<E>());
				i++;
			}
		}
		
		System.out.println(lol.toString());
	}
	
	public static <E extends Comparable<E>> boolean checkValid(E sum,E binsize) {
		if (sum.compareTo(binsize) > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static <E extends Number> int calSum(ArrayList<E> list) {
		int total = 0;
		for(int i = 0;i < list.size();i++) {
			total += list.get(i).intValue();
			}
		return total;
	}
	
}
