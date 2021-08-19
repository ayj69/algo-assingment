package algoass;

import java.util.ArrayList;
import java.util.Scanner;



public class test implements Algo {

	public static void main(String[] args) {
		int itemn = 0;
		int size = 0;
		int choice = 0;
		boolean errorFlag = false;
		Scanner scan = new Scanner(System.in);
		System.out.println("welcom to bin packing problem");
		System.out.println("pls enter your number of item: ");
		do {
			try {
				errorFlag = false;
				itemn = scan.nextInt();
				
			}catch(Exception e) {
				errorFlag = true;
				System.out.print("ERROR\n");
				System.out.print("Press any key to continue . . .\n ");
			    scan.nextLine();
			}
		}while(errorFlag);
		ArrayList<Item<Integer>> itemArray = new ArrayList<Item<Integer>>();
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>(itemn,itemArray);
		System.out.print("you have " + is.numberOfItem + " item.\n");
		System.out.print("then pls decide if you want to enter the number of the item one by one or generate it automaticaly: \n");
		System.out.print("\t\t1:i will do it by myself.\n");
		System.out.print("\t\t2:fine, i will let computer read from external file\n");
		System.out.println("");
		do {
			try {
				do {
					errorFlag = false;
					System.out.print("pls enter your choice: ");
					choice = scan.nextInt();
				}while(!(choice == 1 || choice == 2));
			}catch(Exception e) {
				errorFlag = true;
				System.out.print("ERROR\n");
				System.out.print("Press any key to continue . . . \n");
			    scan.nextLine();
			}
		}while(errorFlag);
		
		if (choice == 1) {
			for (int i = 0;i < itemn;i++) {
				try {
					System.out.print("pls enter the size for current item " + (i+1) + " : ");
					size = scan.nextInt();
				}catch(Exception e) {
					System.out.print("ERROR\n");
					System.out.print("Press any key to continue . . .\n ");
				    scan.nextLine();
				}

				is.itemList.add(new Item<Integer>(size));
			}
		}
		System.out.print(is.itemList.toString());
		is.shittySort(is.itemList);
		System.out.print(is.itemList.toString());
		System.out.println("pls enter your bi size");
		do {
			try {
				errorFlag = false;
				itemn = scan.nextInt();
				
			}catch(Exception e) {
				errorFlag = true;
				System.out.print("ERROR\n");
				System.out.print("Press any key to continue . . .\n ");
			    scan.nextLine();
			}
		}while(errorFlag);
		BinList<Integer> binl = new BinList<Integer>(itemn);
		
		System.out.print("pls chose a method to arrange your set :\n");
		System.out.print("\t\t1.first fit decreasing\n");
		System.out.print("\t\t2.next fit\n");
		System.out.print("pls enter your choice: ");
		
		do {
			try {
				do {
					errorFlag = false;
					System.out.print("pls enter your choice: ");
					choice = scan.nextInt();
				}while(!(choice == 1 || choice == 2));
			}catch(Exception e) {
				errorFlag = true;
				System.out.print("ERROR\n");
				System.out.print("Press any key to continue . . . \n");
			    scan.nextLine();
			}
		}while(errorFlag);
		
		if (choice == 1 ) {
			//we are doing ffd
			is.shittySort(is.itemList);
			ffd(binl.binSize,is.numberOfItem,is.itemList);
		}else if(choice == 2 ) {
			nextInt(binl.binSize,is.numberOfItem,is.itemList);
			
		}

		
	}
	
	
		public static <E extends Number & Comparable<E>> void nextInt(int binsize,int itemnumber,ArrayList<Item<E>> itemList) {
		
		ArrayList<ArrayList<E>> lol = new ArrayList<ArrayList<E>>();
		lol.add(new ArrayList<E>());
		int i = 0;
		int j = 0;
		while(j<itemnumber) {
			if (checkValid(calSum(lol.get(i)) + itemList.get(j).getSize().intValue(),binsize)) {
				lol.get(i).add(itemList.get(j).getSize());
				j++;
			}else {
				lol.add(new ArrayList<E>());
				i++;
			}
		}
		
		System.out.println(lol.toString());
	}
		public static <E extends Number & Comparable<E>>  void ffd(int binsize,int itemnum,ArrayList<Item<E>> itemList) {
		
		ArrayList<ArrayList<E>> lol = new ArrayList<ArrayList<E>>();
		lol.add(new ArrayList<E>());
		int i = 0;
		
		for (int itemCount = 0;itemCount < itemList.size();) {
			for (int arrayCount = 0;arrayCount < lol.size() && itemCount < itemList.size();arrayCount++) {
				
				if (checkValid(calSum(lol.get(arrayCount))+itemList.get(itemCount).getSize().intValue(),binsize)) {
					lol.get(arrayCount).add(itemList.get(itemCount).size);
					itemCount++;
				}
				System.out.println(lol.toString());	
				i = arrayCount;
			}
			if(!checkValid(calSum(lol.get(i))+itemList.get(itemCount-1).getSize().intValue(),binsize)){
				lol.add(new ArrayList<E>());
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


