// problem link : https://leetcode.com/problems/network-delay-time/submissions/

// solution 
class Solution {
    class Pair implements Comparable<Pair>{
        int v;
        int time;
        Pair(int v, int time){
            this.v = v;
            this.time = time;
        }
        public int compareTo(Pair o){
            return this.time-o.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<int[]>> graph = new HashMap<>();
        for(int i = 1; i<=n; i++){
            graph.put(i,new ArrayList<>());
        }
        
        for(int i = 0; i<times.length; i++){
            graph.get(times[i][0]).add(times[i]);
        }
        
        boolean visited[] = new boolean[n+1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k,0));
        int ans = Integer.MIN_VALUE;
        int count = 0;
        while(pq.size()>0){
            Pair rem = pq.remove();
            if(visited[rem.v]) continue;
            visited[rem.v] = true;
            count++;
            ans = rem.time;
            for(int[] a: graph.get(rem.v)){
                if(!visited[a[1]]){
                    pq.add(new Pair(a[1],rem.time+a[2]));
                }
            }
        }
        
        if(count!=n){
            return -1;
        }
        return ans;
    }
}
