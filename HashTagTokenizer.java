import java.util.Arrays;

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		// System.out.println(hashTag.substring(1,3));
		// System.out.println(Arrays.toString(dictionary));
		// System.out.println(existInDictionary(hashTag, dictionary));
		breakHashTag(hashTag, dictionary);
		// System.out.println("i".substring(1));
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];

		In in = new In(fileName);

		for(int i=0;i<dictionary.length;i++){
			dictionary[i]=in.readString();
		}

		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {

	for (String dictWord : dictionary) {
		if(dictWord.equals(word)) return true;
	}
			return false;
		
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		hashtag = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
 
        int N = hashtag.length();

        for (int i = 1; i <= N; i++) {
			String subStr = hashtag.substring(0,i);
			if(existInDictionary(subStr, dictionary)){
				System.out.println(subStr);
				String newHashtag;
				newHashtag = hashtag.substring(i);
				breakHashTag(newHashtag, dictionary);
			}
        }
    }

}
