package icpc.midatl.midatl2010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * https://icpcarchive.ecs.baylor.edu/index.php?option=com_onlinejudge&Itemid=8&category=403&page=show_problem&problem=2864
 * 
 * Greedy: 
 * in terms of avoiding biggest "punishment" (Math.abs(da-db)) at each step
 * not in terms of finding the next smallest value to add (Math.min(da, db)) at each step
 * 
 * example that second case will fail:
 * 2 20 40
 * 20 5 20
 * 20 10 10000
 * 
 * @author Wenshun Liu
 *
 */
public class B {
   
   class Team implements Comparable<Team> {
      public int da;
      public int db;
      public int k;
      
      Team(int da, int db, int k) {
         this.da = da;
         this.db = db;
         this.k = k;
      }

      @Override
      public int compareTo(Team t) {
         int diff = Math.abs(this.da - this.db);
         int otherDiff = Math.abs(t.da - t.db);
         
         return otherDiff - diff;
      }
   }
   

   Scanner in = new Scanner(System.in);
   
   private void go() {
      
      while (in.hasNext()) {
         int n = in.nextInt();
         if (n == 0) break;
         int a = in.nextInt();
         int b = in.nextInt();
         
         List<Team> teams = new ArrayList<>();
         
         for (int i = 0; i<n; i++) {
            int k = in.nextInt();
            int da = in.nextInt();
            int db = in.nextInt();
            teams.add(new Team(da, db, k));
         }
         long total = 0;
         
         Collections.sort(teams);
         
         for (int i = 0; i< n; i++) {
            Team team = teams.get(i);
            int countA = 0;
            int countB = 0;
            if (team.da < team.db) {
               countA = Math.min(team.k, a);
               countB = team.k - countA;
            } else {
               countB = Math.min(team.k, b);
               countA = team.k - countB;
            }
            
            total += (long)countA * team.da + (long)countB * team.db;
            a -= countA;
            b -= countB;
         }
         
         
         System.out.println(total);
      }
   }
   
   public static void main(String[] argss) {
      new B().go();
   }
}
