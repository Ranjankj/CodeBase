// problem limk : https://leetcode.com/problems/lexicographical-numbers/




class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=9; i++){
            solve(i,n,list);
        }
        return list;
    }
    
    public void solve(int i, int n, List<Integer> list){
        if(i>n){
            return;
        }
        
        list.add(i);
        for(int j = 0; j<=9; j++){
            solve(i*10+j, n, list);
        }
    }
}