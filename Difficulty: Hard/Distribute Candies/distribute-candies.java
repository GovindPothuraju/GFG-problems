/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    int moves=0;
    public int distCandy(Node root) {
        // code here
        traversal(root);
        return moves;
    }
    private int traversal(Node curr){
        if(curr==null)return 0;
        int left =traversal(curr.left);
        int right =traversal(curr.right);
        
        moves += Math.abs(left)+Math.abs(right);
        
        int net = curr.data+left+right-1;
        return net;
    }
}