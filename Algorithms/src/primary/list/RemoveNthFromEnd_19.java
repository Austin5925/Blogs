package primary.list;

/**
 * 传统解法与快慢指针
 * @author Ausdin
 * @version 1.0
 */
public class RemoveNthFromEnd_19 {

    public static ListNode removeNthFromEndTraditional(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode cur = head;
        int cnt = 0;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        int num = cnt - n;
        if (num < 0) return null;
        cur = dummy;
        while (num-- >= 0) { //第一个元素/只有一个元素的情况，如果可以一起写就不要拆开来写
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return dummy.next; //不能写head。考虑1个元素情况
    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode fastIndex = dummyNode;
        ListNode slowIndex = dummyNode;

        //只要快慢指针相差 n 个结点即可
        for (int i = 0; i < n  ; i++){
            fastIndex = fastIndex.next;
        }

        while (fastIndex.next != null){
            fastIndex = fastIndex.next;
            slowIndex = slowIndex.next;
        }

        //此时 slowIndex 的位置就是待删除元素的前一个位置。
        //具体情况可自己画一个链表长度为 3 的图来模拟代码来理解
        slowIndex.next = slowIndex.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        int[] arr = {1};
        //写个for循环初始化链表,arr表示链表所有元素
//        ListNode dummyHead = new ListNode();
//        ListNode curNode = dummyHead;
        ListNode curNode = new ListNode();
        ListNode head = curNode;
        int n = 2;
        for (int i = 0; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
//            System.out.println(curNode.val);
        }
        removeNthFromEnd(head.next, n);
    }
}
