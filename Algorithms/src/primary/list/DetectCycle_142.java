package primary.list;

/**
 * 关键是理解x = z,环的开头要找到
 *
 * @author Ausdin
 * @version 1.0
 */
public class DetectCycle_142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) { // 不用考虑slow，fast注意前后顺序
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = head;
                ListNode index2 = slow;
                while (index2 != index1) {
                    index2 = index2.next;
                    index1 = index1.next;
                }
                return index2;
            }
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
