package src.studentRecordsBackup.util;

/**
*
*Class EvenFilterImpl implements OddEvenFilterI interface
*and overrides the check() method in it to check whether the
*given value is even or not 
*
*/

public class EvenFilterImpl implements OddEvenFilterI{
	
	/**
	 *
	 *check(int) is used to check if the given updateValue
	 *passed is even or not
	 *
	 *@param updateValue- Integer variable to be checked if even or not.
	 *
	*/
	@Override
	public boolean check(int updateValue){
		
		if((updateValue % 2) == 0){
			return true;
		}
		return false;
	}
	
}
