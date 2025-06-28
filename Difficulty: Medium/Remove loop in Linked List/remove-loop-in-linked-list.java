/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // code here
        //1 detect cycle
        Node slow=head;
        Node fast=head;
        boolean cycle=false;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                cycle=true;
                break;
            }
        }
        if(cycle){
            // 2 slow = head
            slow=head;
            if(slow==fast){
                Node prev=fast;
                while(prev.next!=slow){
                    prev=prev.next;
                }
                prev.next=null;
            }
            // 3 remove cycle;
            else{
                Node prev=null;
                while(slow!=fast){
                    prev=fast;
                    slow=slow.next;
                    fast=fast.next;
                }
                prev.next=null;
            }
        }
    }
}