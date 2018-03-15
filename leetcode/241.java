public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        
        for (int i = 0; i< input.length(); i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*') {
                List<Integer> left_result = diffWaysToCompute(input.substring(0, i));
                List<Integer> right_result = diffWaysToCompute(input.substring(i+1));
                
                for (int j = 0; j<left_result.size(); j++) {
                    for (int k = 0; k < right_result.size(); k++) {
                        if (input.charAt(i) == '-') {
                            result.add(left_result.get(j) - right_result.get(k));
                        } else if (input.charAt(i) == '+') {
                            result.add(left_result.get(j) + right_result.get(k));
                        } else {
                            result.add(left_result.get(j) * right_result.get(k));
                        }
                    }
                }
            }
        }
        
        if (result.isEmpty()) {
            result.add(Integer.parseInt(input));
        }
        
        return result;
    }
}