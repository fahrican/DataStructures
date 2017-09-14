package hackerrank;

import java.util.*;

public class Solution {

	public static boolean canWin(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false.
		return depthFirstSearch(leap, game, 0);
	}

	private static boolean depthFirstSearch(int leap, int[] game, int indexInArray) {

		// check if your index is below 0 (out of bound) and if your index has stored
		// the value 1
		if (indexInArray < 0 || game[indexInArray] == 1) {
			return false;
		}
		// If you're standing in cell n - 1 or the value of index+leap >= n.length,
		// you can walk or jump off the end of the array and win the game.
		else if (indexInArray == (game.length - 1) || (indexInArray + leap) >= game.length) {
			return true;
		}
		// Mark cell as visited
		game[indexInArray] = 1;

		// you can move from index to index - 1, index + 1, or index + leap
		// as long as the destination index is a cell containing a 0
		return depthFirstSearch(leap, game, indexInArray - 1) || depthFirstSearch(leap, game, indexInArray + 1)
				|| depthFirstSearch(leap, game, indexInArray + leap);
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println((canWin(leap, game)) ? "YES" : "NO");
		}
		scan.close();

	}// end of main method

}// end of class Solution
