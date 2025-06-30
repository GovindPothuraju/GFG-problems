/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    static Node segregate(Node head) {
        // code here
        Node zero=new Node(-1);
        Node one=new Node(-1);
        Node two=new Node(-1);
        Node zeroh=zero,oneh=one,twoh=two;
        Node temp=head;
        while(temp != null){
            if(temp.data == 0){
                zero.next=temp;
                zero=zero.next;
            }else if(temp.data == 1){
                one.next=temp;
                one=one.next;
            }else{
                two.next=temp;
                two=two.next;
            }
            temp=temp.next;
        }
        zero.next=(one.data == -1)?twoh.next:oneh.next;
        one.next=twoh.next;
        two.next=null;
        head=zeroh.next;
        return head;
    }
}