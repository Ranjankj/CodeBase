//problem Limk
//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/abbreviation-suing-backtracking-official/ojquestion


// Solution
package backtracking;

public class WordAbbrivation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefg";
		print(s, 0, "", 0);
	}

	public static void print(String s, int i, String ssf, int count) {
		if (i >= s.length()) {
			if (count == 0) {
				// it means there is no number left to print
				// eg: abcdefg
				System.out.println(ssf);
			} else {
				// if there is a count the we have to append it
				// eg : abc4
				System.out.println(ssf + count);
			}
			return;
		}
		
		
		
		// case1 when we choose the word
		if (count == 0) {
			// if count ==0 that means we only append the current character
			print(s, i + 1, ssf + s.charAt(i), 0);
		} else {
			// if count greater than 0, we append character with the count
			print(s, i + 1, ssf + count + s.charAt(i), 0);
		}
		// case2 when we not choose the word then we only increase the count
		print(s, i + 1, ssf, count + 1);
	}

}
