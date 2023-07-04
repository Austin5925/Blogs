package primary.list;

import java.util.Stack;

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
            cur = temp; //先pre再temp
        }
        return prev; //注意不是cur
    }

    public static ListNode reverseListRecursiveWrong(ListNode head) { // 错误示范！出现死循环
        if (head.next != null) {
            return (reverseListRecursiveWrong(head.next).next = head); // 递归：反过来，带点方程思想（？）
        } else {
            return head;
        }
    }

    public static ListNode reverseListRecursive(ListNode pre, ListNode cur) { //写法上参考双指针
        if (cur == null) {
            return pre; //pre是最终的反转链表
        }
        ListNode temp = null;
        temp = cur.next;
        cur.next = pre;
        return reverseListRecursive(cur, temp);
    }

    public ListNode reverseListUsingDummy(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = temp;//更新
        }
        return dummy.next;//注意不要return cur
    }

    public ListNode reverseListUsingStack(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = dummy; // 可能卡住
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            cur.next = node;
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
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
        System.out.println(reverseListRecursive(null, head.next));
    }
}
