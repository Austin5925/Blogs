package primary.list;

/**
 * 思路一：新开一个ArrayList存进A的元素，对链表B遍历
 * 思路二：对齐数组，which is adopted in 本题
 *
 * @author Ausdin
 * @version 1.0
 */
public class GetIntersectionNode_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //分别求出A，B长度
        ListNode curA = new ListNode(-1);
        ListNode curB = new ListNode(-1);
        curB.next = headB;
        curA.next = headA;
        int cntA = 0, cntB = 0;
        while (curA != null) {
            cntA++;
            curA = curA.next;
        }
        while (curB != null) {
            cntB++;
            curB = curB.next;
        }

        // 对齐两个链表
        curB = headB;
        curA = headA;
        int commonLength = cntA - cntB > 0 ? cntB : cntA;
        int difference = Math.abs(cntA - cntB);
        for (int i = 0; i < difference; i++) {
            if (cntA - cntB > 0)    curA = curA.next;
            else    curB = curB.next;
        }

        while (commonLength-- > 0) {
            if (curB == curA)   return curA;
            else {
                curB = curB.next;
                curA = curA.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNodeStandard(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
