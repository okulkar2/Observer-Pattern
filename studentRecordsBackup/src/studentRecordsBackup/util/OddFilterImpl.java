package src.studentRecordsBackup.util;

/**
*
*Class OddFilterImpl implements OddEvenFilterI interface
*and overrides the check() method in it to check whether the
*given value is odd or not 
*
*/
public class OddFilterImpl implements OddEvenFilterI{
	
	/**
	 *
	 *check(int) is used to check if the given updateValue
	 *passed is odd or not
	 *
	 *@param updateValue- Integer variable to be checked if odd or not.
	 *
	*/
	@Override
	public boolean check(int updateValue){
		
		if((updateValue % 2) != 0){
			return true;
		}
		return false;
	}
	
}
