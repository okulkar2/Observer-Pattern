package src.studentRecordsBackup.bst;

import java.util.HashMap;
import java.util.Map;

import src.studentRecordsBackup.util.OddEvenFilterI;

/**
*
*Class Node is used to create a Node to store
*bNumber, flag which is used by BST to create a tree.
*
*/
public class Node implements SubjectI,ObserverI{
	
	private int bNumber;
	private boolean flag;
	private Node left;
	private Node right;
	private HashMap<ObserverI, OddEvenFilterI> observers;
	
	public Node(int bNumberIn){
		bNumber = bNumberIn;
		flag = false;
		left = null;
		right = null;
	}
	
	/**
	 *
	 *registerObserver(ObserverI ,OddEvenFilterI ) is used to 
	 *register the observer along with correspoding filter.
	 *	evenfilter for backup1
	 *	oddfilter for backup2
	 *
	 *@param oberver- ObserverI(interface) variable containing the reference
	 *                of the observer tree which is to be registered 
	 *       oddeven- OddEvenFilterI(inteface) variable containing filter 
	 *                to be applied to the backup.
	 *
	*/
	@Override
	public void registerObserver(ObserverI observer, OddEvenFilterI oddeven){
		observers.put(observer, oddeven);
	}
	
	/**
	 *
	 *removeObserver(ObserverI) is used to remove observer from 
	 *the Subject's list.
	 *	
	 *@param oberver- ObserverI(interface) variable containing the reference
	 *                of the observer tree which is to be removed from list.
	 *
	*/
	@Override
	public void removeObserver(ObserverI observer){
		OddEvenFilterI getObserver = observers.get(observer);
		
		if(getObserver != null){
			observers.remove(observer);
		}
	}
	
	/**
	 *
	 *notifyObservers(int ,int ) is used to notify the observers in the 
	 *subject's list about change in Subject. 
	 *
	 *@param updateValue- Integer Value to select the backup Node 
	 *       value1- Integer value containing the new value of the Subject 
	 *
	*/
	@Override
	public void notifyObservers(int updateValue,int value1){
		
			for(Map.Entry<ObserverI, OddEvenFilterI> value : observers.entrySet()){
				if(flag == false){
					if(value.getValue().check(updateValue)){
						value.getKey().update(value1);
					}
				}
			}
	}

	/**
	 *
	 *update(int) is used to update observer's bNumber with the number passed
	 *as parameter.
	 *
	 *@param updateValue- Integer value which Observer uses to update its bNumber
	 *
	*/
	@Override
	public void update(int updateValue){
		setbNumber(updateValue);
	}

	/**
	 *
	 *updatebNumber(Node ,int ) is used to update the subject Node
	 *of the BST with the update_value.
	 *
	 *@param node1- Node variable containing the node which has to be updated 
	 *       updateValue- Integer variable used for updating the Node.
	 *
	*/
	public void updatebNumber(Node node1, int updateValue){
		int value1 = updateValue + getbNumber();
		setbNumber(value1);
		notifyObservers(updateValue,value1);
	}
	
	/**
	 *
	 *createObserverList() is used to initialize the Datastructure in this 
	 *case HashMap to store observers.
	 *
	*/
	public void createObserverList(){
		observers = new HashMap<ObserverI, OddEvenFilterI>();
	}
	
	/**
	 *
	 *getbNumber() is used to return the B Number
	 *of the Node being referred
	 *
	 *@return bNumber of the current Node
	 *
	*/
	public int getbNumber() {
		return bNumber;
	}

	/**
	 *
	 *setbNumber() is used to set the bNumber of the current Node
	 *of the BST to the passed bNumberIn value.
	 *
	 *@param bNumberIn- Integer variable which is used to set  Node
	 *                of the current Node. 
	 *
	*/
	public void setbNumber(int bNumberIn) {
		bNumber = bNumberIn;
	}

	/**
	 *
	 *isFlag() is used to return the current value
	 *stored in the flag variable.
	 *
	 *@return the current value of the flag. 
	 *
	*/
	public boolean isFlag() {
		return flag;
	}

	/**
	 *
	 *setFlag() is used to set the flag of the current Node
	 *to true or false of the passed flagIn value.
	 *
	 *@param flagIn- Boolean variable which is used to set value
	 *               of flag of the current Node. 
	 *
	*/
	public void setFlag(boolean flagIn) {
		flag = flagIn;
	}

	/**
	 *
	 *getLeft() is used to return the left Node
	 *of the current Node  of the BST.
	 *
	 *@return left Node of the current Node
	 *
	*/
	public Node getLeft() {
		return left;
	}

	/**
	 *
	 *setLeft() is used to set the left Node of the current Node
	 *of the BST to the passed leftIn Node.
	 *
	 *@param leftIn- Node variable which is used to set left Node
	 *                of the current Node. 
	 *
	*/
	public void setLeft(Node leftIn) {
		left = leftIn;
	}

	/**
	 *
	 *getRight() is used to return the right Node
	 *of the current Node  of the BST.
	 *
	 *@return Right Node of the current Node
	 *
	*/
	public Node getRight() {
		return right;
	}

	/**
	 *
	 *setRight() is used to set the right Node of the current Node
	 *of the BST to the passed rightIn Node.
	 *
	 *@param rightIn- Node variable which is used to set right Node
	 *                of the current Node. 
	 *
	*/
	public void setRight(Node rightIn) {
		right = rightIn;
	}
	
}
