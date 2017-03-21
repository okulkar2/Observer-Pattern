package src.studentRecordsBackup.bst;

/**
*
*Interface ObserverI declares the method update() which is
*overridden by the classes which update the observer after 
*subject changes its state
*
*/
public interface ObserverI {
	public void update(int updateValue);
}
