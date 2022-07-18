// https://leetcode.com/problems/word-search/

// solution
class Solution {
    public boolean exist(char[][] board, String word) {
        
        int n = board.length; 
        int m = board[0].length;
      
      
        for(int i=0; i<n; i++){
            for(int j = 0; j<m; j++){
                char ch = board[i][j];
              
              // when we find the first word of the String word we try to search for the rest of the words
                if(word.charAt(0)==ch){
                    boolean b = find(board,i,j,word,0, new boolean[n][m]);
                    if(b) return b;
                }
            }
        }
        return false;
    }
    
    
    public boolean find(char[][] board, int sr, int sc, String word, int idx, boolean[][]visited){
      //if idx == word.length then we have completed our search so return true;
        if(idx==word.length()){
            return true;
        }
      
        if(sr<0 || sc<0 ||sr>=board.length || sc>=board[0].length|| visited[sr][sc]){
            return false;
        }
        
      
      // if we found the word on board then we search for the next word in the board
      // by making call to all 4 adjacent neighbours 
      // first we mark it visited so that we can't make call again to that cell
      // while coming back we unmark the word
        if(board[sr][sc]==word.charAt(idx)){
            visited[sr][sc] = true;
            boolean b1 = find(board,sr,sc+1,word,idx+1,visited);
            boolean b2 = find(board,sr+1,sc,word,idx+1,visited);
            boolean b3 = find(board,sr,sc-1,word,idx+1,visited);
            boolean b4 = find(board,sr-1,sc,word,idx+1,visited);
            visited[sr][sc] = false;
          
          // if from any of the 4 neighbours we get a true that means we found our answer so we are returning "OR" of all 4 paths. 
            return b1||b2||b3||b4;
        }
        
       return false;
    }
}
