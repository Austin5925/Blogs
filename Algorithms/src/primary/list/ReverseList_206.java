package primary.list;

/**
 * lv2
 * 双指针法
 * @author Ausdin
 * @version 1.0
 */
public class ReverseList_206 {

//    ListNode head;

//    public ReverseList_206(ListNode head) {
//        head = new ListNode(0);
//    }

    public ListNode reverseList(ListNode list) {
//        ListNode head = new ListNode(0, list); // 此处不需要dummyHead
        ListNode prev = null;
        ListNode cur = list;
        ListNode temp = null; // 不加入temp无法正常循环，也不需要为第一次循环单独写语句

        while (cur != null) { //注意不是cur.next
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev; //注意不是cur
    }

    public static ListNode reverseListRecursive(ListNode head) { // 错误示范！出现死循环
        if (head.next != null) {
            return (reverseListRecursive(head.next).next = head); // 递归：反过来，带点方程思想（？）
        } else {
            return head;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        //写个for循环初始化链表,arr表示链表所有元素
//        ListNode dummyHead = new ListNode();
//        ListNode curNode = dummyHead;
        ListNode curNode = new ListNode();
        ListNode head = curNode;
        for (int i = 0; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
//            System.out.println(curNode.val);
        }
        System.out.println(reverseListRecursive(head.next));
    }
}
