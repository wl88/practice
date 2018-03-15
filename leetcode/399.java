public class Solution {
     class Node {
        String label;
        double value;
        
        Node(String s, double d) {
            label = s;
            value = d;
        }
    }
    class Result {
        boolean success;
        double result;
        
        Result(boolean b, double d) {
            success = b;
            result = d;
        }
    }
        
    HashSet<String> visited;
        
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        HashMap<String, ArrayList<Node>> graph = new HashMap<String, ArrayList<Node>>();
        HashSet<String> library = new HashSet<String>();
        
        for (int i = 0; i < equations.length; i++) {
            library.add(equations[i][0]);
            library.add(equations[i][1]);
            
            if (!graph.containsKey(equations[i][0])) {
                ArrayList<Node> adjacentList = new ArrayList<Node>();
                adjacentList.add(new Node(equations[i][1], values[i]));
                graph.put(equations[i][0], adjacentList);
            } else {
                ArrayList<Node> adjacentList = graph.get(equations[i][0]);
                adjacentList.add(new Node(equations[i][1], values[i]));
                graph.put(equations[i][0], adjacentList);
                
            }
            
            if (!graph.containsKey(equations[i][1])) {
                ArrayList<Node> adjacentList = new ArrayList<Node>();
                adjacentList.add(new Node(equations[i][0], 1 / values[i]));
                graph.put(equations[i][1], adjacentList);
            } else {
                ArrayList<Node> adjacentList = graph.get(equations[i][1]);
                adjacentList.add(new Node(equations[i][0], 1 / values[i]));
                graph.put(equations[i][1], adjacentList);
            }
        }
        
        double[] results = new double[queries.length];
        for (int i = 0; i< queries.length; i++) {
            String a = queries[i][0];
            String b = queries[i][1];
            
            if (!library.contains(a) || !library.contains(b)) {
                results[i] = -1.0;
                continue;
            }
            
            visited = new HashSet<String>();
            visited.add(a);
            
            Result r = dfs(1, b, a, graph);
            results[i] = r.result;
        
        }
        return results;
    }
    
    public Result dfs(double result, String target, String current, HashMap<String, ArrayList<Node>> graph) {
        if (target.equals(current)) {
            return new Result(true, result);
        }
        
        
        ArrayList<Node> adjacentList = graph.get(current);
        
        for (Node n: adjacentList) {
            if (!visited.contains(n.label)) {
                visited.add(n.label);
                double result_new = result * n.value;
                
                Result r = dfs(result_new, target, n.label, graph);
                if (r.success) return r;
            }
        }
        
        
        return new Result(false, -1.0);
    }
    
}