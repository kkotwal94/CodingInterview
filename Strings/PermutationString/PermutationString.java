import java.util.Arrays;
class PermutationString {
 /**
 Given two strings, write a method to decide if one is a permutation of another

 What really is a permutation?
 the string but in a different order potentially
 first thing to check is if they are different sizes, if so then one is not a permutation of another
 another is to check if they are both strings 

 Lastly I think of one possible solution being where we check the characters are the same as another word by sorting the characters in both arrays
 if we use a nLogn algorithm than its 2nLogn for sorting both character arrays, there has to be a better way

 what if we just count the number of each letter and its occurrance?
 **/


 /**
 I checked each occurence using a boolean array, since they are O(1) space, so i guess using two would be O(2) space? Maybe I could figure
 out something to use O(1) space instead, a clever trick, but doing so I just switched each bit or boolean at a certain position everytime we 
 saw a character, seeing the same character twice, or three times means that we would flip the boolean value for that character that many time.
 So what if we have a string like doop, or poop, then the value of 'o' in our character array would be the same for both, but the 'd' would be set true
 in one character array. In this case they are different character sets and not permutations of each other.
 **/

 public boolean isPermutation(String wordone, String wordtwo ) {
 	//base cases
 	if(wordone.length() != wordtwo.length()) {
 		return false;
 	}
 	int length = wordone.length();
 	//is the word ascii? If it is then 256 is the largest it can be
 	if(wordone.length() > 256 || wordtwo.length() > 256) {
 		return false;
 	}
 	boolean[] char_set_1 = new boolean[256];
 	boolean[] char_set_2 = new boolean[256];
 	//two boolean char sets for each word
 	//one iteration to set each word
 	for(int i = 0; i < length; i++) {
 		int value_1 = wordone.charAt(i); //grab its ascii value from word 1
 		int value_2 = wordtwo.charAt(i); //grab its ascii value from word 2
 		if(char_set_1[value_1]) {  //if its already set to true
 			char_set_1[value_1] = false;
 		}
 		if(char_set_2[value_2]) { //if its already set to true
 			char_set_2[value_2] = false;
 		}
 		if(!char_set_1[value_1]) { //if its already set to false
 			char_set_1[value_1] = true;
 		}
 		if(!char_set_2[value_2]) { //if its already set to false
 			char_set_2[value_2] = true;
 		}
 		//System.out.println("reached end of for loop");
 	} 

 	if(Arrays.equals(char_set_1, char_set_2)) { //check if our two arrays are equal
 			return true;
 		}
 	//if they are not equal then return false
 	return false;
 }

	public static void main(String[] args) {
		PermutationString perm = new PermutationString();
		System.out.println(perm.isPermutation("doop", "poop"));
	}
}