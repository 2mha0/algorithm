package cqupt.edu.zmh.previous;

import org.junit.Test;

/***
 * https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */
public class IntersectionOfTwoLinkedListsLCCI {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // 思路是两个嵌套循环把所有的组合遍历完
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;

        while (head1 != null){
            while (head2 != null){
                if (head1 == head2){
                    return head1;
                }
                head2 = head2.next;
            }
            head1 = head1.next;
            head2 = headB;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        int sizeA = 0,sizeB = 0;
        ListNode head1 = headA;
        ListNode head2 = headB;
        // 先获取两个链表的长度
        while (head1 != null){
            sizeA++;
            head1 = head1.next;
        }
        while (head2 != null){
            sizeB++;
            head2 = head2.next;
        }
        int n = Math.abs(sizeA-sizeB);
        head1 = headA;
        head2 = headB;
        if (sizeA > sizeB){
            while (n != 0){
                head1 = head1.next;
                n--;
            }
        }else if (sizeB > sizeA){
            while (n != 0){
                head2 = head2.next;
                n--;
            }
        }
        while (head1 != null){
            if (head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    @Test
    public void test(){
        ListNode headA = new ListNode(4);
        headA.addLast(1);
        ListNode headB = new ListNode(5);
        headB.addLast(0);
        headB.addLast(1);
        ListNode headC = new ListNode(8);
        headC.addLast(4);
        headC.addLast(5);
        headA.concat(headC);
        headB.concat(headC);



        ListNode node = getIntersectionNode(headA,headB);
        System.out.println(node.val);
    }
}
