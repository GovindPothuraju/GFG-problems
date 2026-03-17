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
    HashMap<Node,Node> parentMap=new HashMap<>();
    Node startNode;
    public int minTime(Node root, int target) {
        // code here
        buildParent(root,null);
        
        HashSet<Node> visited=new HashSet<>();
        Queue<Node> q=new LinkedList<>();
        
        getStart(root,target);
        
        q.add(startNode);
        visited.add(startNode);
        
        int time=-1;
        
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                Node temp=q.poll();
                
                //left
                if(temp.left != null && !visited.contains(temp.left)){
                    q.add(temp.left);
                    visited.add(temp.left);
                }
                
                //right
                if(temp.right!=null && !visited.contains(temp.right)){
                    q.add(temp.right);
                    visited.add(temp.right);
                }
                
                //parent
                Node parent=parentMap.get(temp);
                if(parent!=null && !visited.contains(parent)){
                    q.add(parent);
                    visited.add(parent);
                }
            }
            time++;
        }
        return time;
    }
    private void buildParent(Node curr,Node par){
        if(curr==null)return;
        parentMap.put(curr,par);
        buildParent(curr.left,curr);
        buildParent(curr.right,curr);
    }
    
    private void getStart(Node curr,int tar){
        if(curr==null)return ;
        if(curr.data==tar){
            startNode=curr;
            return ;
        }
        getStart(curr.left,tar);
        getStart(curr.right,tar);
    }
}