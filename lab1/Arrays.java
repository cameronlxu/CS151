public class Tester {
  // Swap largest & smallest elements in array
  // If there are multiple largest or smallest elements, pick the first one.
  
  public static int[] swapLargestAndSmallest(int[] list) {
      // base case
      if (list.length == 0 || list.length == 1){ return list; }

      int biggest = list[0];
      int smallest = list[0];
      int biggestIndex = 0;
      int smallestIndex = 0;

      // Discover biggest & smallest elements with their indexes
      for(int i = 1; i < list.length; i++) {
          if (list[i] > biggest) {
              biggest = list[i];
              biggestIndex = i;
          } else if (list[i] < smallest) {
              smallest = list[i];
              smallestIndex = i;
          } else {
              continue;
          }
      }

      // Swap elements
      int temp = list[biggestIndex];
      list[biggestIndex] = list[smallestIndex];
      list[smallestIndex] = temp;

      return list;
  }

  public static void main(String[] args) {
      int[] a = new int[] { 5, 4, 1, 9, 2, 6 };
      Arrays.swapLargestAndSmallest(a);
      System.out.println(java.util.Arrays.toString(a));
      System.out.println("Expected: [5, 4, 9, 1, 2, 6]");
      a = new int[] { 1, 4, 1, 9, 2, 6 };
      Arrays.swapLargestAndSmallest(a);
      System.out.println(java.util.Arrays.toString(a));
      System.out.println("Expected: [9, 4, 1, 1, 2, 6]");
      a = new int[] { 1, 4, 2, 9, 9, 6 };
      Arrays.swapLargestAndSmallest(a);
      System.out.println(java.util.Arrays.toString(a));
      System.out.println("Expected: [9, 4, 2, 1, 9, 6]");
      a = new int[] { 1 };
      Arrays.swapLargestAndSmallest(a);
      System.out.println(java.util.Arrays.toString(a));
      System.out.println("Expected: [1]");
  }
}
