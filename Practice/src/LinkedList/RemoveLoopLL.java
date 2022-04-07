package LinkedList;

public class RemoveLoopLL {

    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) {
                slow=head;
                //when slow and fast meet at the head node(loop starts at the head node)
                if(slow==fast) {
                    //move fast till head/slow since its a loop
                    while(fast.next!=slow) {
                        fast=fast.next;
                    }
                    fast.next=null;
                }
                else {
                    while(slow!=fast) {
                        prev=fast;
                        slow=slow.next;
                        fast=fast.next;
                    }
                    prev.next=null;
                }
                break;
            }
        }
    }
}
