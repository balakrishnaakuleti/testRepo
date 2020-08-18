import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySplitterEnhanced {
	static int j;

	public static void main(String[] args) {
		List<String> inputArray = Arrays.asList("A", "B", "C","D");
		List<List<String>>output = split_array(inputArray, 3);
		printList(output);
	}

	// Enhanced method to use ArrayLists and streams
	public static List<List<String>>split_array(List<String> inputArray, int childCount) {

		//Child lists
		List<List<String>> children = new ArrayList<List<String>>();

		//Effective Size of Output Array
		int effectiveArraySize = inputArray.size()<childCount?inputArray.size():childCount;

		//Initialize the child list
		for(int i=0;i<effectiveArraySize; i++) {
			children.add(new ArrayList<String>());
		}

		j=0;
		//Populate the children from the parent array using streams
		inputArray.forEach(element -> {children.get((j++)%effectiveArraySize).add(element);});
		return children;
	}

	// Method to print the child arrays
	public static void printList(List<List<String>>output) {
		for ( List<String> childArray : output) {
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
