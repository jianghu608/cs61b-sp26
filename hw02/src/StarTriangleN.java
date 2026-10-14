public class StarTriangleN {
   /**
     * Prints a right-aligned triangle of stars ('*') with N lines.
     * The first row contains 1 star, the second 2 stars, and so on. 
     */
   public static void starTriangle(int N) {
      // TODO: Fill in this function
      // 先打印空格，再打印*，最后换行
      for (int star = 1; star <= N; star++) {
         int space = N - star;
         for (int i = 1; i <= space; i++) { IO.print(" "); }
         for (int j = 1; j <= star; j++) { IO.print("*"); }
         IO.println();
      }
   }
   
   public static void main(String[] args) {
      starTriangle(7);
   }
}