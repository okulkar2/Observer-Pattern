package src.studentRecordsBackup.util;

import src.studentRecordsBackup.bst.BST;
import src.studentRecordsBackup.bst.Node;

public class BSTBuilder {
	private FileProcessor fileInput;
	private String fileName;
	
	public BSTBuilder(String fileNameIn){
		fileName = fileNameIn;
	}
	
	public void buildTree(BST root1,BST root2, BST root3){
	
		String line;
		int value;
		boolean flag = false;
		
		OddEvenFilterI filter;
		
			fileInput = new FileProcessor(fileName);
		
			while((line = fileInput.readLineFromFile()) != null){
				
				try{
					value = Integer.parseInt(line);
					flag = true;
				}
				catch(NumberFormatException ex){
					continue;
				}
				
				root1.insert(value);
				//flag = true;
				root2.insert(value);
				root3.insert(value);
			
				Node parent = root1.getNode();
				parent.createObserverList();
			
				Node child1 = root2.getNode();
				filter = new EvenFilterImpl();
				parent.registerObserver(child1, filter);
			
				filter = new OddFilterImpl();
				Node child2 = root3.getNode();
				parent.registerObserver(child2, filter);
			
			}
			if(flag == false){
				fileInput.closeFile();
				System.err.println("Error: File is Blank");		 
	    		System.exit(1);  
			}
			fileInput.closeFile();
	}
	
	
}
