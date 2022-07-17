// problem limk: https://leetcode.com/problems/path-with-maximum-gold/


// solution
class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans =0;        
        for(int i= 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] !=0){
                    int temp =findGold(grid,i,j,new boolean[n][m]);
                    // System.out.println(temp);
                    ans = Math.max(ans,temp);
                }
            }
        }
        return ans;
    }
    
    public static int findGold(int [][]grid, int sr, int sc,boolean[][] visited){
        if(sr<0 || sc<0 || sr>= grid.length || sc>=grid[0].length || 
           visited[sr][sc] || grid[sr][sc]==0){ 
            return 0;
        }
        
        visited[sr][sc] = true;
        
        int g1 = findGold(grid,sr,sc+1, visited);
        int g2= findGold(grid,sr+1,sc, visited);
        int g3= findGold(grid,sr,sc-1, visited);
        int g4= findGold(grid,sr-1,sc, visited);
         visited[sr][sc] = false;
        
        int max = Math.max(g1,Math.max(g2,Math.max(g3,g4)));
        
        return grid[sr][sc]+max;
    }
    
    
}
