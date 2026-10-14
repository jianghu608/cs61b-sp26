public class DoubleUp {
   /**
     * Returns a new string where each character of the given string is repeated twice.
     * Example: doubleUp("hello") -> "hheelllloo"
     */
   public static String doubleUp(String s) {
      // TODO: Fill in this function
      /*
      String sDouble = "";

      for (int i = 0; i < s.length(); i++) {
         sDouble += s.charAt(i);
         sDouble += s.charAt(i);
      }

      return sDouble;
      */
      StringBuilder sDouble = new StringBuilder();

      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         sDouble.append(c).append(c);
      }

      return sDouble.toString();
   }
   
   public static void main(String[] args) {
      String s = doubleUp("hello");
      System.out.println(s);
      
      System.out.println(doubleUp("cat"));
   }
}