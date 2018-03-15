public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //System.out.println("\n");
        ArrayList<Integer> current_list = new ArrayList<Integer>();
        for (int i = 0; i< nums.length; i++) {
            current_list.add(nums[i]);
        }
        Random rand = new Random();
        
        while (current_list.size() > 1) {
            //int pivot_index = ThreadLocalRandom.current().nextInt(0, current_list.size());
            int pivot_index = rand.nextInt(current_list.size());
            int pivot = current_list.get(pivot_index);
            
            ArrayList<Integer> left_list = new ArrayList<Integer>();
            ArrayList<Integer> equal_list = new ArrayList<Integer>();
            ArrayList<Integer> right_list = new ArrayList<Integer>();
            
            for (int i = 0; i< current_list.size(); i++) {
                if (current_list.get(i) < pivot) {
                    left_list.add(current_list.get(i));
                } else if (current_list.get(i) == pivot) {
                    equal_list.add(current_list.get(i));  
                } else{
                    right_list.add(current_list.get(i));
                }
            }
            // System.out.println("left list: " + left_list);
            // System.out.println("equal list: " + equal_list);
            // System.out.println("right list: " + right_list);
            // System.out.println("k: " + k);
            
            if (right_list.size()  + equal_list.size() < k) {
                //System.out.println("chose left");
                current_list = left_list;
                k = k - right_list.size() - equal_list.size();
            } else if (left_list.size()  + equal_list.size() <= current_list.size() - k) {
                //System.out.println("chose right");
                current_list = right_list;
            } else {
                //System.out.println("chose equal");
                current_list = equal_list;
                break;
            }
        }
        
        return current_list.get(0);
    }
}