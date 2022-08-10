// question limk : https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

// solution: 

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[] = new boolean[V];
        boolean stack[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                if(dfs(adj,i,visited,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> graph, int v, boolean visited[], boolean stack[]){
        visited[v] = true;
        stack[v] = true;
        
        for(int nbr: graph.get(v)){
            if(!visited[nbr]){
                if(dfs(graph,nbr,visited,stack)){
                    return true;
                }
            }else if(stack[nbr]){
                return true;
            }
        }
        stack[v] = false;
        return false;
    }
}
