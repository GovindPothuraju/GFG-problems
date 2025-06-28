/*
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        // code here.
        /*Node slow=head;
        Node fast=head;
        int count=0;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            count++;
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                cycle=true;
                break;
            }
        }
        if(cycle){
            return count;
        }else{
        return 0;
        }*/
        HashMap<Node,Integer> hm=new HashMap<>();
        Node temp=head;
        int t=0;
        while(temp!=null){
            if(hm.containsKey(temp)){
                int val=hm.get(temp);
                
                return t-val;
            }else{
                hm.put(temp,t);
                t++;
                temp=temp.next;
            }
        }
        return 0;
    }
}