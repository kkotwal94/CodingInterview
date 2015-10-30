class replaceSpace {

	/**
	Write a method to replace all spaces in a string with'%20'. You may assume that
	the string has sufficient space at the end of the string to hold the additional
	characters, and that you are given the "true" length of the string. (Note: if implementing
	in Java, please use a character array so that you can perform this operation
	in place.)
	EXAMPLE
	Input: "Mr John Smith    " (4 blank spaces at end)
	Output: "Mr%20John%20Smith"
	**/

	/**
	I think the idea i want to take is to read each character one at a time, by doing so as soon as i see a space in my iteration, then I 
	add a %, 2, 0 in that order and continue iterating, for each space I see, I do that exact procedure.
	**/

	//O(n) time, O(n) space, what if we were given a character array instead of a string? Then we would have to manipulate it in place?
	public String editString(String word) {
		int length = word.length();
		char[] char_set = new char[length];
		int tracker =0;
		String newString = " ";
		for(int i = 0; i < length; i++) {
			
			if(word.charAt(i) == ' ' && word.charAt(i+1) == ' ') {
				newString = new String(char_set);
				return newString;
			}

			char value = word.charAt(i);
			if(value == ' '){
				char_set[tracker] = '%';
				char_set[tracker+1] = '2';
				char_set[tracker+2] = '0';
				tracker = tracker + 3;
			}
			else {
				char_set[tracker] = value;
				tracker = tracker + 1;
			}
		}
		return newString;
		}




	public static void main(String[] args) {
		replaceSpace replace = new replaceSpace();
		System.out.println(replace.editString("hello w orld    "));
	}
}