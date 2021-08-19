package algoass;

import java.util.ArrayList;

public class testtesttest {

	public static void main(String arg[]) {
		
		ArrayList<Integer> intarr = new ArrayList<Integer>();
		
		for (int i = 0;i < 5;i++) {
			intarr.add((int)((Math.random())*100)+1);
		}
		for (int i = 0;i < 5;i++) {
			intarr.add((int)((Math.random())*10)+1);
		}
		
	
		int binsize = 100;
		int itemnum = intarr.size();
		System.out.println(itemnum);
		shittySort(intarr);
		System.out.println(intarr.toString());
		//ffd
		//sortdone
		//next is algo
		ffd(binsize,itemnum,intarr);
		//i am so fucking done
		
		
		
		
		
	}
	
	public static <E extends Number> void ffd(int binsize,int itemnum,ArrayList<E> list) {
		
		ArrayList<ArrayList<E>> lol = new ArrayList<ArrayList<E>>();
		lol.add(new ArrayList<E>());
		int i = 0;
		
		for (int itemCount = 0;itemCount < list.size();) {
			for (int arrayCount = 0;arrayCount < lol.size()&&itemCount < list.size();arrayCount++) {
				
				if (checkValid(calSum(lol.get(arrayCount)) + list.get(itemCount).intValue(),binsize)) {
					lol.get(arrayCount).add(list.get(itemCount));
					itemCount++;
				}
				System.out.println(lol.toString());	
				i = arrayCount;
			}
			if(!checkValid(calSum(lol.get(i)) + list.get(itemCount-1).intValue(),binsize)){//need to custom this
				lol.add(new ArrayList<E>());
			}
		}
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
	
	public static <E extends Comparable<E>> ArrayList<E> shittySort(ArrayList<E> list){
		//find minimum then replace it
		//loop 1
		for (int i=0;i < list.size();i++) {
			E min = list.get(i);
			//loop 2
			for (int j = 0;j<list.size();j++) {
				if (list.get(i).compareTo(list.get(j)) > 0) {
					min = list.get(j);
					list.set(j, list.get(i));
					list.set(i, min);
				}
			}
		}
		return list;
	}
	
	
}
