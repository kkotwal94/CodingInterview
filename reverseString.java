class reverseString {

	//Takes O(n/2) time which is the same as O(n), but takes O(n) space since strings are immutable in java, in C+, we can use O(1) space with pointers
	public String reverse(String word) {
		//System.out.println(word);
		int length = word.length(); //the size of the word
		int end = length-1; //the end of the character array
		char temp; //temp value
		//word = 'world'  dlrow
		//word = 'keen'  neek
		char[] str = word.toCharArray(); //switch to a character array, since strings are immutable
			for(int i = 0; i < length / 2; i++) { //iterate to only half the string length, since we're just swapping
			 	temp = str[i]; // remember the beginning value
			 	str[i] = str[end]; //set beginning to end
			 	str[end] = temp; //end is set to beginning
			 	end = end - 1; //decrement the end by one to swap the second last character now
			}
		System.out.println(str); //print out our string, to see it
		String reversedWord = new String(str); //convert it back to string
		return reversedWord; 
	}
	
	public static void main(String[] args) {
		reverseString rString = new reverseString();
		System.out.println(rString.reverse("apple"));
	}
}	