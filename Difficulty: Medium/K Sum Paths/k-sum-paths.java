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
    int count=0;
    HashMap<Long,Integer> hm=new HashMap<>();
    public int countAllPaths(Node root, int k) {
        // code here
        //base case to handle
        if(root==null)return count;
        hm.put(0L,1);
        traversal(root,0L,k);
        return count;
    }
    private void traversal(Node root,long sum,int k){
        sum+=root.data;
        long rem=sum-k;
        if(hm.containsKey(rem)){
            count+=hm.get(rem);
        }
        hm.put(sum,hm.getOrDefault(sum,0)+1);
        if(root.left != null)traversal(root.left,sum,k);
        if(root.right != null)traversal(root.right,sum,k);
        hm.put(sum,hm.get(sum)-1);
        if(hm.get(sum)==0){
            hm.remove(sum);
        }
    }
}