class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[adj.size()];
        
        st.push(0);
        
        while(!st.isEmpty()){
            int node = st.pop();
            
            if(visited[node]) continue;
            
            visited[node] = true;
            res.add(node);
            
            ArrayList<Integer> temp = adj.get(node);
            
            for(int i = temp.size()-1; i >= 0; i--){
                int val = temp.get(i);
                if(!visited[val]){
                    st.push(val);
                }
            }
        }
        
        return res;
    }
}