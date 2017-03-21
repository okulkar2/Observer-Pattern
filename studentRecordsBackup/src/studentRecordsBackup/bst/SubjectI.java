package src.studentRecordsBackup.bst;

import src.studentRecordsBackup.util.OddEvenFilterI;

/**
*
*Interface SubjectI declares the three methods which are
*overridden by the subject class to conform to Observer pattern.
*
*/
public interface SubjectI {
	public void registerObserver(ObserverI observer,OddEvenFilterI oddeven);
	public void removeObserver(ObserverI observer);
	public void notifyObservers(int updateValue,int value1);
}
