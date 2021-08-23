package algoass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public interface Algo {
	
	//Auto generate an integer based on the min and max range given
	public static int autoGenInt(int min, int max) {
		Random ran = new Random();
		return ran.nextInt(max + 1) + min ;
	}
	
	//next fit method
	public static <E extends Number & Comparable<E>> void nextFit(int binsize,int itemnumber,ArrayList<Item<E>> itemList) {
		
		Stack<Stack<E>> stack = new Stack<Stack<E>>();
		Bin<E> bin = new Bin<E>(stack);
		bin.getStack().add(new Stack<E>());
		int i = 0;
		int j = 0;
		
		while(j<itemnumber) {
			if (checkValid(calSum(bin.getStack().get(i)) + itemList.get(j).getSize().intValue(),binsize)) {
				bin.getStack().get(i).add(itemList.get(j).getSize());
				j++;
			}else {
				bin.getStack().add(new Stack<E>());
				i++;
			}
		}
		
		System.out.println(bin.toString());

	}
	
	//first fit decreasing method
	public static <E extends Number & Comparable<E>> void ffd(int binsize,int itemnum,ArrayList<Item<E>> itemList) {
		
		
		Stack<Stack<E>> stack = new Stack<Stack<E>>();
		Bin<E> bin = new Bin<E>(stack);
		bin.getStack().add(new Stack<E>());
		boolean flag = false;
		
		for (int itemCount = 0;itemCount < itemList.size();) {
			for (int arrayCount = 0;arrayCount < stack.size() && itemCount < itemList.size();arrayCount++) {
				flag = false;
				if (checkValid(calSum(bin.getStack().get(arrayCount))+itemList.get(itemCount).getSize().intValue(),binsize)) {
					bin.getStack().get(arrayCount).add(itemList.get(itemCount).size);
					itemCount++;
				}else
					flag = true;
			}
			if(flag){
				bin.getStack().add(new Stack<E>());
			}
		}
		System.out.println(bin.toString());
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
	
	//read the file path of a file
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
	public static boolean readFile(File ads) {
    	
   	 try {
		      File myObj = new File(ads.getAbsolutePath());
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        myReader.nextInt();
		      }
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println(e.toString());
		      System.out.println(ads.getName() + " might have some error pls pick another file");//get back to selection then disable the choice
		      return false;
		    }
   	 
   	 return true;
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
	    
    //get user input and validate it using the range given
    public static int  getUserInput(int min,int max) {
			
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
	   
    //get user input and validate it using the range given also passing a message to print
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
