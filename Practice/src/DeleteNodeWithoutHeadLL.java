public class DeleteNodeWithoutHeadLL {

    void deleteNode(Node1 del)
    {
        // Your code here
        del.data=del.next.data;
        del.next=del.next.next;
    }
}
