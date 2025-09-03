class Solution {
    // Function to reverse the queue.
    public Queue<Integer> reverseQueue(Queue<Integer> q) {
        // code here.
        Stack<Integer> st=new Stack<>();
        while(!q.isEmpty()){
            st.push(q.poll());
        }
        Queue<Integer> res=new LinkedList<>();
        while(!st.isEmpty()){
            res.offer(st.pop());
        }
        return res;
    }
}