// User function Template for Java
class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        Stack<Integer> temp=new Stack<>();
        while(!st.isEmpty()){
            temp.push(st.peek());
            st.pop();
        }
        Stack<Integer> res=new Stack<>();
        res.push(x);
        while(!temp.isEmpty()){
            res.push(temp.peek());
            temp.pop();
        }
        return res;
    }
}