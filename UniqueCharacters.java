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

	public static void main(String[] args) {
		UniqueCharacters unique = new UniqueCharacters();
		unique.isUnique("apple");	
	}
}