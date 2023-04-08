package cqupt.edu.zmh.previous;

import org.junit.Test;

/***
 * https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    // 头节点存储数据计算链表长度
    public int sizeOfList(ListNode head){
        if (head == null) return 0;
        int size = 1;
        ListNode cur = head.next;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }

    /**
     * 大致思想是找到正数的索引然后执行删除
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        if (head == null) return null; // 输入为null
        int size = sizeOfList(head);
        int index = size - n;
        ListNode cur = head;
        if (index == 0 && n == 1)   // 输入了一个元素，删除这个元素
            return null;
        else if (index == 0){   // 当输入元素个数与n相等时，也就是删除第一个元素
            head = head.next;
            return head;
        }
        // 找到带删除节点的前一个节点索引
        for (int i = 1; i < index; i++) {
            cur = cur.next;
        }
        if (cur.next.next == null)  // 删除节点是最后个节点时
            cur.next = null;
        else
            cur.next = cur.next.next;
        return head;
    }

    /***
     * 双指针的经典应用，如果要删除倒数第n个节点，让fast移动n步，然后让fast和slow同时移动，
     * 直到fast指向链表末尾。删掉slow所指向的节点就可以了。
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // 链表只有一个元素且需要删除第一个元素
        if (fast == null && n == 1){
            return null;
        }
        // 链表长度与n相等，也就是说需要删除第一个元素
        if (fast == null){
            head = head.next;
            return head;
        }
        while (fast.next != null){
            slow = slow.next;   // slow指向待删除节点的前一个节点
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.addLast(2);
        head.addLast(3);
        head.addLast(4);
        head.addLast(5);
        removeNthFromEnd(head,1).display();
    }
}
