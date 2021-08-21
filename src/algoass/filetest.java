package algoass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class filetest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();

		System.out.println(getItemListScanFilelol().toString());
		
	}
public static  ItemSet<Item<Integer>> getItemListScanFilelol() {
		
		ItemSet<Item<Integer>> is = new ItemSet<Item<Integer>>();
		ArrayList<File> file = new ArrayList<File>(Algo.readFilePath("src/algoass/data"));
		int fileChoice = 0;
		fileChoice = Algo.getitemnumber(1, file.size(), "pls enter your another file choice : ");
        fileChoice -= 1;
        System.out.println("your choice is : " + file.get(fileChoice).getName());
        while(!(readFile(file.get(fileChoice)))) {
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
			        int data = myReader.nextInt();
			      }
			      myReader.close();
			    } catch (Exception e) {
			      System.out.println(ads.getName() + "might have some error pls pick another file");//get back to selection then disable the choice
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
	    

}
