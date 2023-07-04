package primary.list;

/**
 * @author Ausdin
 * @version 1.0
 */
public class ExchangeNode_24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode cur = head;
        ListNode cur2 = head.next;
        while(cur.next != head){
            int temp = cur2.val;
            cur2.val = cur.val;
            cur.val = temp;
            if (cur2.next == null || cur2.next.next == null) { //短路避免NPE
                break;
            } else {
                cur = cur2.next;
                cur2 = cur2.next.next;
            }
        }
        return head;
        //草，才看到：你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。重写一个罢
    }

    public static ListNode swapPairs2(ListNode head) {
        if (head == null) return null; // 0
        if (head.next == null) return head; // 1
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode cur2 = head.next;
        ListNode temp = null;
        head = cur2;
        while(cur.next != null){ // 2
            temp = cur2.next;
            cur.next = temp;
            cur2.next = cur;
            dummy.next = cur2;
            if (temp == null || temp.next == null) break; //3, 4, 短路避免NPE
            dummy = cur;
            cur = temp;
            cur2 = temp.next;
        }
        return head;
    }

    public ListNode swapPairsStandard(ListNode head) {
        ListNode dumyhead = new ListNode(-1); // 设置一个虚拟头结点
        dumyhead.next = head; // 将虚拟头结点指向head，这样方面后面做删除操作
        ListNode cur = dumyhead;
        ListNode temp; // 临时节点，保存两个节点后面的节点
        ListNode firstnode; // 临时节点，保存两个节点之中的第一个节点
        ListNode secondnode; // 临时节点，保存两个节点之中的第二个节点
        while (cur.next != null && cur.next.next != null) {
            temp = cur.next.next.next;
            firstnode = cur.next;
            secondnode = cur.next.next;
            cur.next = secondnode;       // 步骤一
            secondnode.next = firstnode; // 步骤二
            firstnode.next = temp;      // 步骤三
            cur = firstnode; // cur移动，准备下一轮交换
        }
        return dumyhead.next;
    }

    public static ListNode swapPairsRecursive(ListNode head) { // 递归版本好抽象，一定多理解两遍
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairsRecursive(next.next); // 两个来一次
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
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


        swapPairsRecursive(head.next);
    }
}
