/*Node is defined as
class Node
{
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        // Code here
        long mod=(long)Math.pow(10,9)+7;
        long num1=0;
        long num2=0;
        while(first != null || second != null){
            if(first != null){
                num1=((num1*10)+first.data)%mod;
                first=first.next;
            }
            if(second != null){
                num2=((num2*10)+second.data)%mod;
                second=second.next;
            }
        }
        return (num1*num2)%mod;
    }
}