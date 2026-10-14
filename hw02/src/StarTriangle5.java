public class StarTriangle5 {
   /**
     * Prints a right-aligned triangle of stars ('*') with 5 lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle5() {
      // TODO: Fill in this function
      int length = 5;
      for (int star = 1; star < 6; star++) {
         int space = length - star;
         for (int i = 1; i <= space; i++) { IO.print(" "); }
         for (int j = 1; j <= star; j++) { IO.print("*"); }
         IO.println();
      }
   }
   
   public static void main(String[] args) {
      starTriangle5();
   }
}
