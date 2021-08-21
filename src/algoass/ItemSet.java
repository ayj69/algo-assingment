package algoass;

import java.io.File;
import java.util.ArrayList;



public class ItemSet<T> implements Algo{
	//create a concrete item class and put it in array list
	//so in this object it should have only concrete item 
	//for example [Integer,Double,Long]
	int numberOfItem ;
	int binSize;
	ArrayList<T> itemList = new ArrayList<T>();
	
	public ItemSet() {
		this.numberOfItem = 0;
	}
	
	public ItemSet(int numberOfItem) {
		this.numberOfItem = numberOfItem;
	}
	
	public ItemSet(ArrayList<T> list) {
		this.itemList = list;
	}
	
	public ItemSet(int numberOfItem,ArrayList<T> list) {
		this.numberOfItem = numberOfItem;
		this.itemList = list;
	}
	
	public ItemSet(int binsize , int numberOfItem,ArrayList<T> list) {
		this.numberOfItem = numberOfItem;
		this.itemList = list;
		this.binSize = binsize;
	}
	
	public int getBinSize() {
		return binSize;
	}

	public void setBinSize(int binSize) {
		this.binSize = binSize;
	}
	
	public String toString() {
		return "There are " + this.numberOfItem + " item in the set right now.\n" +
				"All item = " + (itemList.iterator().hasNext()?itemList.toString(): "no item in set")+ " in teh set.\n";
	}
	
	//increasing sort//this shit will not work
	//todo: make a BETTER sorting system..//postpone postpone
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
	
	public ItemSet<Item<Integer>> getItemListManual() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();
		int binSize = Algo.getitemnumber(0, 1000000,"Pls enter your Bin size : ");
		int itemNumber = Algo.getitemnumber(0, 1000000,"Pls enter your number of item : ");
		is = new ItemSet<Item<Integer>>(binSize,itemNumber,itemArray);
		for (int i = 0;i < is.numberOfItem;i++) {
			int size = Algo.getitemnumber(0, is.binSize,"pls enter your size of the item : ");
			is.itemList.add(new Item<Integer>(size));
		}
		return is;
		
	}
	
	public  ItemSet<Item<Integer>> getItemListAutoGen() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();
		int binSize = Algo.getitemnumber(0, 1000000,"Pls enter your Bin size : ");
		int itemNumber = Algo.getitemnumber(0, 1000000,"Pls enter your number of item : ");
		is = new ItemSet<Item<Integer>>(binSize,itemNumber,itemArray);
		for (int i = 0;i < is.numberOfItem /4 ;i++) {
			is.itemList.add(new Item<Integer>(Algo.autoGenInt(0, binSize/4*3)));
		}
		for (int i = 0;i < (is.numberOfItem / 4 * 3) + (is.numberOfItem % 4);i++) {
			is.itemList.add(new Item<Integer>(Algo.autoGenInt(0, binSize/4)));
		}
        System.out.print(is.toString());
		return is;
		
	}
	
public  ItemSet<Item<Integer>> getItemListScanFile() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<File> file = new ArrayList<File>(Algo.readFilePath("src/algoass/data"));
		int fileChoice = 0;
		fileChoice = Algo.getitemnumber(1, file.size(), "pls enter your another file choice : ");
        fileChoice -= 1;
        System.out.println("your choice is : " + file.get(fileChoice).getName());
        while(!(Algo.readFile(file.get(fileChoice)))) {
        	fileChoice = Algo.getitemnumber(1, file.size(), "pls enter your another file choice : ");
            fileChoice -= 1;
            System.out.println("your choice is : " + file.get(fileChoice).getName());
        }
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();

		itemArray.addAll(Algo.readDataFile(file.get(fileChoice)));
        is = new ItemSet<Item<Integer>>(Algo.findMax(itemArray).size,itemArray.size(),itemArray);
        System.out.print(is.toString());
        System.out.println("Automaticaly set the maximun bin size to " +Algo.findMax(itemArray));
        
		return is;
		
	}
	
	
}

