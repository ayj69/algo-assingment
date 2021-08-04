package dataAlgoAssingment;

import java.util.ArrayList;
import java.util.Iterator;

public class UnsortItemSet extends Item {

	int numberOfItem = 0;
	ArrayList<Item> itemList = new ArrayList<Item>();
	
	public UnsortItemSet() {
		this.numberOfItem = 0;
	}
	
	public UnsortItemSet(int numberOfItem,ArrayList<Item> list) {
		this.numberOfItem = numberOfItem;
		this.itemList = list;
	}
	Iterator<Item> it = itemList.iterator();
	public String toString() {
		return "There are " + this.numberOfItem + " item in the set right now.\n" +
				"All item = " + (itemList.iterator().hasNext()?itemList.toString(): "no item in set")+ " in teh set.\n";
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	//increasing sort//this shit will not work
	public ArrayList<Item> shittySort(ArrayList<Item> list){
		//find min then replace it
		//loop 1
		for (int i=0;i < list.size();i++) {
			Item min = list.get(i);
			//loop 2
			for (int j = 0;j<list.size();j++) {
				if (list.get(i).compareTo(list.get(j)) < 0) {
					min = list.get(j);
					list.set(j, list.get(i));
					list.set(i, min);
				}
			}
		}
		
		return list;
	}

	
	


	
}
