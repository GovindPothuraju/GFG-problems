class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if(q.size()<k) return q;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<k;i++){
            st.push(q.poll());
        }
        while(!st.isEmpty()){
            q.offer(st.pop());
        }
        for(int i=0;i<q.size()-k;i++){
            q.offer(q.poll());
        }
        return q;
    }
}