// problem:  https://leetcode.com/problems/maximum-score-words-formed-by-letters/

class Solution {
    
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int freq[] = new int [26];
        for(char ch: letters){
            int idx = ch-'a';
            freq[idx]++;
        }
        return solve(words,freq,score,0);
        
    }
    
    public static int solve(String[] words,int [] freq, int[] score,int index){
        if(index==words.length){
            return 0;
        }
        
        boolean flag = true;
        int cscore = 0;
        String s = words[index];
        for(int i = 0; i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            cscore += score[idx];
            freq[idx]--;
            if(freq[idx]<0){
                flag = false;
            }
        }
        
        int p1 = 0;
        if(flag){
            p1 = solve(words,freq,score,index+1)+cscore;    
        }
        
        for(int i = 0; i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            freq[idx]++;
        }
        int p2 = solve(words,freq,score,index+1);
        
        return Math.max(p1,p2);
    }
}
