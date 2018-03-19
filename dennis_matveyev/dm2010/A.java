package dennis_matveyev.dm2010;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Wenshun Liu
 * 
 * https://www2.cs.duke.edu/courses/spring10/cps149s/assign/denny2010.pdf
 *
 */

public class A {
   Scanner in = new Scanner(System.in);
   
   private void go() {
      String[] text = {"dollars: ", "quarters: ", "dimes: ", "nickels: ", "pennies: "};
      int[] amount = {100, 25, 10, 5, 1};
      
      int index = 1;
      while (in.hasNext()) {
         String d = in.nextLine();
         if (d.equals("0")) break;
         
         //NOTE: Split uses regular expressions, where '.' is a special character meaning anything. 
         //You need to escape it if you actually want it to match the '.' character
         int value = Integer.parseInt(d.split("\\.")[0])*100 + Integer.parseInt(d.split("\\.")[1]);
         int[] results = new int[text.length];
         for (int i = 0; i < amount.length; i++) {
            results[i] = value / amount[i];
            value = value % amount[i];
         }
         
         System.out.println("Change for customer " + index + ":");
         for (int i = 0; i < text.length; i++) {
            System.out.println(text[i] + results[i]);
         }
         System.out.println();
         
         index++;
      }
   }
   
   public static void main(String[] argss) {
      new A().go();
   }
}
