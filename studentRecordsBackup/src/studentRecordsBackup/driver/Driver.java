
package src.studentRecordsBackup.driver;

import src.studentRecordsBackup.util.BSTBuilder;
import src.studentRecordsBackup.bst.BST;


/**
*
*Driver class is used to implement this assignment
*
*/
public class Driver {
	
	private static int updateValue;
	private static BST main = null;
	private static BST backup1 = null;
	private static BST backup2 = null;
	
	/**
	 *
	 *validate(String[])- It is used validate the argument list 
	 *for condition given as:
	 *If argumentList size = 2
	 *
	 *@param String - argumentList[] 
	 *@return boolean.
	*/
	private boolean validate(String[] argumentList){
		
		if(argumentList.length != 2){
			System.err.println("Error: There should be exactly 2 arguments entered on command line");
			System.err.println("1st argument for FileName 2nd for Update_Value");
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		 Driver driver = new Driver();

		 if(driver.validate(args) == true){
		   
		   	String fileName = args[0];
		   	updateValue = Integer.parseInt(args[1]);
		   	main = new BST();
		   	backup1 = new BST();
		   	backup2 = new BST();
		   	
		   	BSTBuilder bst = new BSTBuilder(fileName);
		    bst.buildTree(main,backup1,backup2);
		    
		    System.out.println("--------------Original Trees---------------");
		    System.out.println("Main BST Tree");
		    main.printInorder(main.getRoot());
		    System.out.print("\nMain BST Tree : ");
		    main.printBSum();
		    
		    System.out.println("\nBackup1 BST Tree");
		    backup1.printInorder(backup1.getRoot());
		    System.out.print("\nBackup1 BST Tree : ");
		    backup1.printBSum();
		    
		    System.out.println("\nBackup2 BST Tree");
		    backup2.printInorder(backup2.getRoot());
		    System.out.print("\nBackup2 BST Tree : ");
		    backup2.printBSum();
		    
		    System.out.println("\n--------------Trees after Update---------------");
		    System.out.println("Update Value: "+ updateValue +"\n");
		    System.out.println("Main BST Tree");
		    main.updateTree(updateValue);
		    main.printInorder(main.getRoot());
		    System.out.print("\nMain BST Tree : ");
		    main.printBSum();
		    
		    System.out.println("\nBackup1 BST Tree");
		    backup1.printInorder(backup1.getRoot());
		    System.out.print("\nBackup1 BST Tree : ");
		    backup1.printBSum();
		    
		    System.out.println("\nBackup2 BST Tree");
		    backup2.printInorder(backup2.getRoot());
		    System.out.print("\nBackup2 BST Tree : ");
		    backup2.printBSum();
		 }
		 else{
				System.exit(1);
		}
	    	
	}    	  

}
