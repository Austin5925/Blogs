package primary.list;

/**
 * @author Ausdin
 * @version 1.0
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, primary.list.ListNode next) { this.val = val; this.next = next; }

}
