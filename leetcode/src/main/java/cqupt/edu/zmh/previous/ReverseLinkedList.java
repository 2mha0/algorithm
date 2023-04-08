package cqupt.edu.zmh.previous;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
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
    // 这种接法很不好：用数组来作为中介进行反转
    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }
        if (head.val == 0 && head.next == null){
            return head;
        }
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            size++;
            temp = temp.next;
        }
        int[] listNums = new int[size];
        int n = size;
        while (head != null){
            listNums[size-1] = head.val;
            size--;
            head = head.next;
        }
        ListNode reverseList = new ListNode();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            // 尾插法
            ListNode node = new ListNode(listNums[i]);
            if (reverseList.val == 0 && !flag){
                reverseList.val = listNums[i];
                flag = true;
            }else {
                ListNode cur = reverseList;
                while (cur.next != null){
                    cur = cur.next;
                }
                cur.next = node;
            }
        }
        return reverseList;
    }

    public ListNode reverseList(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;
        // 指向反转后的子串
        ListNode reverseList = head.next;
        // 指向待反转的字串
        ListNode subList = reverseList.next;
        // 指向后一个待反转字串(也是temp，负责保存subList更新前的值)
        ListNode tempPointer = null;
        // 先断链
        head.next = null;
        // 然后反转连接
        reverseList.next = head;
        while (subList != null){
            tempPointer = subList.next;
            subList.next = reverseList;
            reverseList = subList;
            subList = tempPointer;
        }
        return reverseList;
    }

    @Test
    public void test(){
        ListNode head = new ListNode();
        ListNode reverseList = reverseList(head);
        reverseList.display();
    }
}
