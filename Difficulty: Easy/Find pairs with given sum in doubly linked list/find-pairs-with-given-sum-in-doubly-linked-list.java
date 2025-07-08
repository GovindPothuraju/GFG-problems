/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      Node head) {
        // code here
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Node left=head;
        Node right=findright(head);
        while(left.data < right.data){
            if(left.data + right.data == target){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(left.data);
                temp.add(right.data);
                res.add(temp);
                left=left.next;
                right=right.prev;
            }else if(left.data + right.data > target){
                right=right.prev;
            }else{
                left=left.next;
            }
        }
        return res;
    }
    public static Node findright(Node head){
        while(head.next != null){
            head=head.next;
        }
        return head;
    }
}
