package algoass;

import java.util.ArrayList;



public class Bin <T> {
	
	ArrayList<Item> bin= new ArrayList<Item>();
	
	int size;
	
	public Bin() {
		this.size = 100;
	}
	
	public Bin(int size) {
		this.size = size;
	}
	
	public String toString () {
		return bin.toString();
	}
	
	public Bin(ArrayList<Item> list){
		this.bin = list;
	}
	
	public boolean checkSum(ArrayList<Item<Integer>> list) {
		int total = 0;
		System.out.print(size);
		for(int i = 0;i < list.size();i++) {
			total += list.get(i).size;
			}
		if (total > size)
			return false;
		else 
			return true;
	}

	

	
	}
		
	
	
	
