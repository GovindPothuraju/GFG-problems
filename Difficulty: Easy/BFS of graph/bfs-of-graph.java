class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> res=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        
        boolean[] visited=new boolean[adj.size()];
        
        q.add(0);
        visited[0]=true;
        
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            
            for(int val:adj.get(node)){
                if(!visited[val]){
                    q.add(val);
                    visited[val]=true;
                }
            }
        }
        return res;
    }
}