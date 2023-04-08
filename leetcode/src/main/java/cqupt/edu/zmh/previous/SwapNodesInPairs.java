package cqupt.edu.zmh.previous;

import org.junit.Test;

public class SwapNodesInPairs {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head; // 只有一个节点
        ListNode low = head;
        ListNode mid = head.next;
        ListNode high = mid.next;
        ListNode swapHead = mid;
        while (high != null){
            // 实现两两交换
            mid.next = low;
            if (high.next == null){
                low.next = high;
                return swapHead;
            }else {
                low.next = high.next;
            }

            // 更新指针
            low = high;
            mid = high.next;
            high = high.next.next;
        }
        // 处理最后的尾巴
        mid.next = low;
        low.next = null;
        return swapHead;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.addLast(2);
        head.addLast(3);
        ListNode swapHead = swapPairs(head);
        swapHead.display();
    }
}
