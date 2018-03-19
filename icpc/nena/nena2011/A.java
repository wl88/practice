package icpc.nena.nena2011;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Wenshun Liu
 * 
 * https://www.cs.rit.edu/~icpc/questions/2011/NENA_final_2011.pdf
 *
 */
public class A {

   Scanner in = new Scanner(System.in);
   
   private void go() {
      //labelled branching statement
      OUT:
      while (in.hasNext()) {
         int n = in.nextInt();
         int[] red = new int[n];
         int[] green = new int[n];
         for (int i = 0; i<n; i++) red[i] = in.nextInt();
         for (int i = 0; i<n; i++) green[i] = in.nextInt();
         
         Arrays.sort(red);
         Arrays.sort(green);
         
         for (int i = 0; i<red.length; i++) {
            if (red[i] >= green[i]) {
               System.out.println("NO");
               //nice trick from Kevin's sample solution 
               //http://db.cs.duke.edu/courses/fall12/compsci309s/notes/grinch
               continue OUT;
            }
         }
         System.out.println("YES");
      }
   }
   
   public static void main(String[] argss) {
      new A().go();
   }
}
