package algoass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;


public interface Algo {
	
	public static int autoGenInt(int min, int max) {
		Random ran = new Random();
		return ran.nextInt(max + 1) + min ;
	}
	
	//next fit method
	public static <E extends Number & Comparable<E>> void nextFit(int binsize,int itemnumber,ArrayList<Item<E>> itemList) {
		
		Stack<Stack<E>> stack = new Stack<Stack<E>>(); 
		stack.add(new Stack<E>());
		int i = 0;
		int j = 0;
		while(j<itemnumber) {
			if (checkValid(calSum(stack.get(i)) + itemList.get(j).getSize().intValue(),binsize)) {
				stack.get(i).add(itemList.get(j).getSize());
				j++;
			}else {
				stack.add(new Stack<E>());
				i++;
			}
		}
		
		System.out.println(stack.toString());

	}
	
	//first fit decreasing method
	public static <E extends Number & Comparable<E>>  void ffd(int binsize,int itemnum,ArrayList<Item<E>> itemList) {
		
		ArrayList<ArrayList<E>> lol = new ArrayList<ArrayList<E>>();
		lol.add(new ArrayList<E>());
		boolean flag = false;
		
		for (int itemCount = 0;itemCount < itemList.size();) {
			for (int arrayCount = 0;arrayCount < lol.size() && itemCount < itemList.size();arrayCount++) {
				flag = false;
				if (checkValid(calSum(lol.get(arrayCount))+itemList.get(itemCount).getSize().intValue(),binsize)) {
					lol.get(arrayCount).add(itemList.get(itemCount).size);
					itemCount++;
				}else
					flag = true;
			}
			if(flag){
				lol.add(new ArrayList<E>());
			}
		}
		System.out.println(lol.toString());
	}
	
	//check if the bin can fit or not
	public static <E extends Comparable<E>> boolean checkValid(E sum,E binsize) {
		if (sum.compareTo(binsize) > 0) {
			return false;
		}else {
			return true;
		}
	}
	
	//cal the sum of the bin
	public static <E extends Number> int calSum(List<E> list) {
		int total = 0;
		for(int i = 0;i < list.size();i++) {
			total += list.get(i).intValue();
			}
		return total;
	}
	
	//find the maximum of the array list
	public static <E extends Number & Comparable<E>> Item<E> findMax(ArrayList<? extends Item<E>> list) {
		Item<E> max = list.get(0);
		 for(int i=0; i<list.size(); i++){
		        if(list.get(i).compareTo(max) > 0){
		            max = list.get(i);
		        }
		    }
		return max;
	}
	
  public static ArrayList<File> readFilePath(String filepath) {
	        File actual = new File(filepath);
	        ArrayList<File> file = new ArrayList<File>();
	        int i =1 ;
	        for( File f : actual.listFiles()){
	        	file.add(f);
	            System.out.println( i + " : " + f.getName() );
	            i++;
	        }
	    	return file;
	    }
	    
	    //read the file content then print it
    public static void readFile(File ads) {
	    	
	    	 try {
			      File myObj = new File("src/algoass/Data/data1");
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        String data = myReader.nextLine();
			        System.out.println(data);
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			  }
	    
	    //read the file content the return an array list contain the integer
    public static <E> ArrayList<Item<Integer>> readDataFile(File ads) {
	    	
	    	ArrayList<Item<Integer>> list = new ArrayList<Item<Integer>>(); 
	    	 try {
			      File myObj = new File(ads.getAbsolutePath());
			      Scanner myReader = new Scanner(myObj);
			      while (myReader.hasNextLine()) {
			        int data = myReader.nextInt();
			        list.add(new Item<Integer>(data));
			      }
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
	    	 
			return list;
		 }
	    
	   public static int  getitemnumber(int min,int max) {
			
			int number = 0;
			boolean errorFlag = false;
			Scanner scan = new Scanner(System.in);
			
			do {
				System.out.print("pls enter a number");
				try {
					errorFlag = false;
					number = scan.nextInt();
					if (number > max || number < min) {
						errorFlag = true;
						System.out.print("ERROR\n");
						System.out.print("Number out of range\n ");
						System.out.print("Press any key to continue . . .\n ");
					    scan.nextLine();
					}
				}catch(Exception e) {
					errorFlag = true;
					System.out.print("ERROR\n");
					System.out.print("Press any key to continue . . .\n ");
				    scan.nextLine();
				}
			}while(errorFlag);
			
			return number;
		}
	   
	public static int getitemnumber(int min,int max,String str) {
			
			int number = 0;
			boolean errorFlag = false;
			Scanner scan = new Scanner(System.in);

			do {
				System.out.print(str);
				try {
					errorFlag = false;
					number = scan.nextInt();
					if (number > max || number < min) {
						errorFlag = true;
						System.out.print("ERROR\n");
						System.out.print("Number out of range\n ");
						System.out.print("Press any key to continue . . .\n ");
					    scan.nextLine();
					}
				}catch(Exception e) {
					errorFlag = true;
					System.out.print("ERROR\n");
					System.out.print("Press any key to continue . . .\n ");
				    scan.nextLine();
				}
			}while(errorFlag);
			
			return number;
			
		}
		

	
}
