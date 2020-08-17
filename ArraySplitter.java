public class ArraySplitter {

	public static void main(String[] args) {
		String[] inputArray = { "A", "B", "C", "D","E","F","G" };
		String[][] output = split_array(inputArray, 4);
		printList(output);
	}

	private static String[][] split_array(String[] inputArray, int childCount) {

		// Array to hold lengths of the child arrays
		int[] childLengthArray = new int[childCount];

		// Array to hold the child arrays
		String[][] childArrays = new String[childCount][];

		// Logic to prepare individual child array lengths
		for (int i = 0, j = 0; i < inputArray.length; i++, j++) {
			if (j == childCount) {
				j = 0;
			}
			childLengthArray[j] += 1;
		}

		// Logic to populate the child arrays with the elements from parent array
		for (int i = 0, j = 0, k = 0; i < inputArray.length && k < childLengthArray.length; i++, j++) {
			if (childLengthArray[k] != 0 && j < childLengthArray[k]) {
				if (j == 0) {
					childArrays[k] = new String[childLengthArray[k]];
				}
				childArrays[k][j] = inputArray[i];

			} else {
				j = -1;
				k++;
				i--;
			}
		}
		return childArrays;
	}

	// Method to print the child arrays
	private static void printList(String[][] output) {
		for (String[] childArray : output) {
			System.out.println();
			if (null != childArray) {
				for (String child : childArray) {
					System.out.print(child);
				}
				System.out.println();
			}
		}
	}
}
