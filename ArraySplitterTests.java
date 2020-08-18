import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ArraySplitterTests {
	public static List<String> inputArray = Arrays.asList("A", "B", "C", "D" );

	@Test
	public void testEqualLengthChildren() {
		List<List<String>> expectedOutputArray = Arrays.asList( Arrays.asList("A"), Arrays.asList("B"), Arrays.asList("C"), Arrays.asList("D"));
		List<List<String>> outputArray = ArraySplitterEnhanced.split_array(inputArray, 4);
		assertNotNull(outputArray);
		assertEquals(expectedOutputArray, outputArray);
		assertEquals(4,outputArray.size());
		assertEquals(1, outputArray.get(0).size());
		assertEquals(1, outputArray.get(1).size());
		assertEquals(1, outputArray.get(2).size());
		assertEquals(1, outputArray.get(3).size());
		assertEquals("A", outputArray.get(0).get(0));
		assertEquals("B", outputArray.get(1).get(0));
		assertEquals("C", outputArray.get(2).get(0));
		assertEquals("D", outputArray.get(3).get(0));
	}

	@Test
	public void testUnequalLengthChildren() {
		List<List<String>> outputArray = ArraySplitterEnhanced.split_array(inputArray, 3);
		assertEquals(3,outputArray.size());
		assertEquals(2, outputArray.get(0).size());
		assertEquals(1, outputArray.get(1).size());
		assertEquals(1, outputArray.get(2).size());
		assertEquals("A", outputArray.get(0).get(0));
		assertEquals("B", outputArray.get(1).get(0));
		assertEquals("C", outputArray.get(2).get(0));
		assertEquals("D", outputArray.get(0).get(1));
	}

	@Test
	public void testMoreChildrenThanInputArrayLength() {
		List<List<String>> outputArray = ArraySplitterEnhanced.split_array(inputArray, 6);
		assertEquals(4,outputArray.size());
		assertEquals(1, outputArray.get(0).size());
		assertEquals(1, outputArray.get(1).size());
		assertEquals(1, outputArray.get(2).size());
		assertEquals(1, outputArray.get(3).size());
		assertEquals("A", outputArray.get(0).get(0));
		assertEquals("B", outputArray.get(1).get(0));
		assertEquals("C", outputArray.get(2).get(0));
		assertEquals("D", outputArray.get(3).get(0));
	}
}
