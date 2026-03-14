/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class Pair{
        Node node;
        int col;
        Pair(Node n,int c){
            node=n;
            col=c;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        TreeMap<Integer, Integer> tm=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            
            Pair curr=q.poll();
            if(!tm.containsKey(curr.col)){
                tm.put(curr.col, curr.node.data);
            }
            if(curr.node.left != null) q.offer(new Pair(curr.node.left ,curr.col-1 ));
            if(curr.node.right != null) q.offer(new Pair(curr.node.right ,curr.col+1 ));
        }
        return new ArrayList<>(tm.values());
    }
}