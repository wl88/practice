package leetcode;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class LC47 {
   public List<List<Integer>> permuteUnique(int[] nums) {
      if (nums == null) return null;

      return permuteUniqueHelper(nums, 0);
   } 

   private List<List<Integer>> permuteUniqueHelper(int[] nums, int pos) {
      //System.out.println("nums: " + Arrays.toString(nums) + " pos: " + pos);

      List<List<Integer>> results = new ArrayList<>();

      if (pos == nums.length-1) {
         List<Integer> result = new ArrayList<>();
         for (int i : nums) result.add(i);
         results.add(result);
         return results;
      }

      for (int i = pos; i < nums.length; i++) {
         if (hasDuplicate(nums, pos, i)) continue;

         swap(nums, pos, i);
         results.addAll(permuteUniqueHelper(nums, pos+1));
         swap(nums, pos, i);
      }

      return results;
   }

   private boolean hasDuplicate(int[] nums, int start, int end) {
      for (int i = start; i<end; i++) {
         if (nums[i] == nums[end]) return true;
      }

      return false;
   }

   private void swap(int[] nums, int a, int b){
      int temp = nums[a];
      nums[a] = nums[b];
      nums[b] = temp;
   }

   private void printOutput(int[] nums) {
      System.out.println(new StringBuilder("\na: ")
            .append(Arrays.toString(nums))
            .append("\noutput: ")
            .append(permuteUnique(nums))
            .append("\noutput size: " + permuteUnique(nums).size())
            .toString());
   }


   public static void main(String[] args) {
      LC47 s = new LC47();

      //common
      int[] a = {5,1,3,2};

      //sorted
      int[] b = {4,3,2,1};
      int[] c = {2,3,4,5};

      //duplicats
      int[] d = {1,1,2};
      int[] e = {2,1,1};
      int[] f = {3,2,3,1,2};

      //boundary cases
      int[] g = {1};
      int[] h = {-1};
      int[] i = {1,1,1,1};
      int[] j = {};


      s.printOutput(a);
      s.printOutput(b);
      s.printOutput(c);
      s.printOutput(d);
      s.printOutput(e);
      s.printOutput(f);
      s.printOutput(g);
      s.printOutput(h);
      s.printOutput(i);
      s.printOutput(j);
   }
}