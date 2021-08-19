package algoass;

import java.util.ArrayList;

public class BinList<T> extends Bin<T>{
	
	int binSize;
	ArrayList<ArrayList<Item<Integer>>> itemlist = new ArrayList<ArrayList<Item<Integer>>>();
	ArrayList<ArrayList<Bin<Integer>>> binlist = new ArrayList<ArrayList<Bin<Integer>>>();

	
	public BinList(int size,ArrayList<ArrayList<Item<Integer>>> list) {
		// TODO Auto-generated constructor stub
		this.itemlist = list;
		this.binSize = size;
	}
	
	public BinList(int size) {
		// TODO Auto-generated constructor stub
		this.binSize = size;
	}
	public int getBinSize() {
		return binSize;
	}
	public void setBinSize(int binSize) {
		this.binSize =  binSize;
	}
	
	public boolean checkSumd(ArrayList<Bin> list) {
		int total = 0;
		System.out.print(size);
		for(int i = 0;i < list.size();i++) {
			total += list.get(i).size;
			}
		if (total > (int)size)
			return false;
		else 
			return true;
	}
	
	
	public <E extends Comparable<E>> ArrayList<E> shittySort(ArrayList<E> list){
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
