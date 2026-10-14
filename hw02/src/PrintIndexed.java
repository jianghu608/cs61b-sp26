public class PrintIndexed {
   /**
     * Prints each character of a given string followed by the reverse of its index.
     * Example: printIndexed("hello") -> h4e3l2l1o0
     */
   public static void printIndexed(String s) {
      // TODO: Fill in this function
      int sLength = s.length();

      for (int index = 0; index < sLength; index++) {
         int reverseIndex = sLength - index - 1;
         IO.print(s.charAt(index));
         IO.print(reverseIndex);
      }
      IO.println();
   }

   public static void main(String[] args) {
      printIndexed("hello");
      printIndexed("cat"); // should print c2a1t0
   }
}