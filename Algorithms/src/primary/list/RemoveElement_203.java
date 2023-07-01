package primary.list;

/**
 * 本地初始化链表比数组烦不少。。。
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
//            System.out.println(curNode.val);
        }

        System.out.println(removeElements(dummyHead, val));

//        for (int i = 0; i < curNode.length; i++) {
//            curNode = curNode.next;
//            System.out.println(curNode.val);
//        }


    }

    public static ListNode removeElements(ListNode dummyHead, int val) {
        for (ListNode head = dummyHead.next; head.next == null; head = head.next) {
            if (head.val == val) {
                head.next = head.next.next;
            }
//            if (head.next != null) {
//
//            }
        }
        return dummyHead;
    }
}
