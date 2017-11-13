package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int lastAnswer = 0;
		int numberOfSequences = in.nextInt();
		int numberOfQueries = in.nextInt();
		ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(numberOfSequences);
		
		//initialize the ArrayList objects, to avoid NullPointerException's
		for (int i = 0; i < numberOfSequences; i++) {
			seqList.add(new ArrayList<Integer>());
		}
		
		while (numberOfQueries-- > 0) {
			
			int typeOfQuery = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			int index = ((x ^ lastAnswer) % numberOfSequences);
			ArrayList<Integer> seq = seqList.get(index);
			
			if (typeOfQuery == 1) {
				
				seq.add(y);
			}
			else if (typeOfQuery == 2) {
				
				lastAnswer = seq.get(y % seq.size());
				System.out.println(lastAnswer);
			}
		}
		in.close();
	}

}// end of class Solution
