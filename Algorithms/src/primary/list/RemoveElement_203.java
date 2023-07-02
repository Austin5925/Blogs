package primary.list;

/**
 * 本地初始化链表比数组烦不少。。。
 * 也是双指针的思想
 *
 * @author Ausdin
 * @version 1.0
 */
public class RemoveElement_203 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;
        //写个for循环初始化链表,arr表示链表所有元素
        ListNode dummyHead = new ListNode();
        ListNode curNode = dummyHead;
        for (int i = 0; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
            System.out.println(curNode.val);
        }
        System.out.println(removeElementsStandard(dummyHead.next, val));
    }

    public static ListNode removeElements0(ListNode head, int val) {
        // 错误代码
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                // 如果cur = cur.next.next; 则多往后了一位，NullPointerException
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode removeElementsStandard(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置dummy节点，统一操作
        ListNode dummy = new ListNode(-1, head);
        ListNode pre = dummy; // pre指向待删除节点的前一个节点，初始指向dummy，这个容易遗忘
        ListNode cur = head; // cur指向待删除节点。如果只用一个节点指向，会导致删除后无法继续遍历，标记也很混乱
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
