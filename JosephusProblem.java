//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
// solution: https://youtu.be/dzYq5VEMZIg

class Solution {
    
    public int findTheWinner(int n, int k) {
        return solve(n,k)+1;
    }
    public int solve(int n, int k ){
        if(n==1){
            return 0; 
        }
        int ans = solve(n-1,k);
        return (ans+k)%n;
    }
}
