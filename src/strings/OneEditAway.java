package strings;

public class OneEditAway {
	
	//This method will compare the two strings and determine if they are one edit away or not.
	//The assumptions are the strings contains only alphabets but no restrictions of order of chars.
	boolean isEditAway(String str1, String str2){
		
		//Check if it needs more than one edits then return false.
		if((str1.length()-str2.length())>1 || (str2.length()-str1.length())>1 )
			return false;
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		char[] arr = str1.toCharArray();
		int editsRequired = 0 ;
		int[] frequency = new int[Character.getNumericValue('z') - Character.getNumericValue('a') +1];
		
		for(char c: arr){
			frequency[Character.getNumericValue(c) - Character.getNumericValue('a')]++;
			editsRequired++;
		}
		
		int oldVal, newVal;
		arr = str2.toCharArray();
		for(char c: arr){
			oldVal = frequency[Character.getNumericValue(c) - Character.getNumericValue('a')];
			newVal = --frequency[Character.getNumericValue(c) - Character.getNumericValue('a')];
			if(!( newVal<0 ) )
				editsRequired--;
		}
	
		return editsRequired==1;
	}
	
	//Method 2: if we consider that letters are arranged in order and we can check them
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneEditAway obj = new OneEditAway();
		System.out.println(obj.isEditAway("abcddd","abcde"));
	}

}
