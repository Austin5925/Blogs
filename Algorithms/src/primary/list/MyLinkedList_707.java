package primary.list;

/**
 * 边界情况要先考虑
 *
 * @author Ausdin
 * @version 1.0
 */

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

public class MyLinkedList_707 {

    //size存储链表元素的个数，有了后面才好操作
    int size; //后面其实没有利用size，可以简化思路
    //虚拟头结点
    ListNode head;

    public MyLinkedList_707() {
        size = 0;
        head = new ListNode(0); //避免纠结指向什么赋值
    }

    public int get(int index) {
        ListNode cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
        if (cur.next != null) return cur.next.val; //此处注意返回下一个节点的val
        else return -1;
    }

    public void addAtHead(int val) {
        ListNode newHead = new ListNode(val, head.next);
        head.next = newHead;
        size++;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next; //很基本的理解问题，相当需要注意
        }
        tmp.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode node = new ListNode(val);
        ListNode cur = head; //置0本质是新的dummyhead
        while (index-- > 0) {
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node; // 有dummyhead，不需要cur.next.next，cur.next足够
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        //不加边界情况无法跑通测试用例，别的边界参考标准解法
        ListNode cur = head;
        while (index-- > 1) { // 不需要定义新node指向head！直接head赋给node。注意nullptrexcp
            cur = cur.next;
        }
        cur.next = cur.next.next;
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList_707 myLinkedList = new MyLinkedList_707();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
//        myLinkedList.addAtIndex(1, 2);    // 链表变为 1->2->3
        System.out.println(myLinkedList.get(5));              // 返回 2
        myLinkedList.deleteAtIndex(6);    // 现在，链表变为 1->3
        myLinkedList.deleteAtIndex(4);    // 现在，链表变为 1->3
//        myLinkedList.get(1);              // 返回 3

/*        ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead",
            "addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
        [[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]*/
    }
}
