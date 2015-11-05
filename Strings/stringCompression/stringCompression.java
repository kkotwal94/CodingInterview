class stringCompression {


	/**
	Implement a method to perform basic string compression using the counts
	of repeated characters. For example, the string aabcccccaaa would become
	a2blc5a3. If the "compressed" string would not become smaller than the original
	string, your method should return the original string
	**/
	//a function to measure how big my compression count is going to be
	/**
	Did so by looping through my word, and converting each occurence to a character, so 11 becomes '11' or its size is 2
	**/

	//Takes O(n) space and O(n + n) which is O(2n) which is O(n)
	public int compressionCount(String word) {
		int length = word.length();
		int count = 1;
		int size = 0;
		char last = word.charAt(0);

		for(int i = 0; i < length; i++) {
			if(last == word.charAt(i)) {
				count++;
			}
			else {
				last = word.charAt(i);
				size = size + 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size = size + 1 + String.valueOf(count).length();
		System.out.println(size);
		return size;

	}
	public String compression(String word) {
		int length = word.length();
		int count = 1;
		int pos = 0; //current position in character array
		int size = compressionCount(word);
		if(size > length) {
			System.out.println(word);
			return word;
		}
		char[] char_set = new char[size];
		char last = word.charAt(0);

		for(int i = 0; i < length; i++) {
			if(last == word.charAt(i)) {
				count++;
			}
			else {
			//need to set character count
			pos = characterSet(char_set, pos, count, last);
			last = word.charAt(i);
			count = 1;
			}
		}
		pos = characterSet(char_set, pos, count, last);
		String compressedString = new String(char_set);
		System.out.println(compressedString);
		return compressedString;
	}

	public int characterSet(char[] array, int pos, int count, char currentChar) {
		array[pos] = currentChar;
		pos++;
		char[] countString = String.valueOf(count).toCharArray();
		for(char x : countString) {
			array[pos] = x;
			pos++;
		}
		return pos;
	}

	public static void main(String[] args) {
		stringCompression sCompress = new stringCompression();
		sCompress.compression("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacd");
	}
}



//adddfqq