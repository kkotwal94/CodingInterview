import java.util.HashSet;
import java.util.Iterator;

class UniqueCharacters {


	/**
	The question here is to determine if all the letters in a given string are unique, first approach should be atleast O(n) time (I think),
	but my method will use O(n) space. The question also asks how you would do it with just O(1) space
	**/

	//If we have O(N) space why not use a HashMap or HashSet? Easy Access, add, delete
	//So what is the difference between a hashmap and a hashset, well a hashSet references to a mathematical set such as :
	// {1, 3, 6, 2}, whereas a map represents something more along the lines of {a -> 1, b -->3, c --> 2}

	//Important, a hashmap allows multiple values, but every key must be distinct, whereas a HashSet allows no same elements in the set
	//For uniqueness I think a hashset is more viable here.

	//O(n) time, we iterate through the word once if it is unique (worst case) using a hashSet of size N.
	public Boolean isUnique(String word){
		int i;
		HashSet checker = new HashSet();

		for(i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i)+ " "); //can't index strings in java, use charAt
			if(checker.add(word.charAt(i)) == false) {
				System.out.println("False with the character " + word.charAt(i));
				return false;
			}
		}
		System.out.println(word + " has only unique characters");
		return true;
	}


	//O(n) time, O(1) space
	//Can we iterate through the array and just have a variable to keep track, but doing that we would have to check everytrhing against everything else, thats n^2 time
	//Can we some how use something that is true and false, a boolean that is long, maybe bits?
	//We can maybe turn on bits for every letter we see, but what kind of bit do we use?

	public Boolean isUniqueByBits(String word) {
		//this is our base case for checking if a word is acceptable to begin with.
		if(word.length() > 256){ //for ascii length, if it is a ascii string/word
			return false;
		}

		boolean[] characterbits = new boolean[256]; //create a bunch of bits/booleans of size 256, for the amount ascii characters there are

		for(int i = 0; i < word.length(); i++) { //iterating through word
			char val = word.charAt(i); //val is the char at that word
			int vals = word.charAt(i); //returns the ascii value of the character, by stating the character as a int
			System.out.println(vals); //prints out the ascii value
			if(characterbits[val]) {
				return false;
			}
			characterbits[val] = true;
			//System.out.println(characterbits[val]);
		}
		
		return true;
	}


	public static void main(String[] args) {
		UniqueCharacters unique = new UniqueCharacters();
		//unique.isUnique("apple");	
		System.out.println(unique.isUniqueByBits("apple"));
	}
}