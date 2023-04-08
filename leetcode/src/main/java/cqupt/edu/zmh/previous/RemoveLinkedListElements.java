package cqupt.edu.zmh.previous;

import org.junit.Test;

public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {this.val = 0;}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        // 头插法
        public void addFirst(int val){
            ListNode node = new ListNode(val);
            node.next = this.next;
            this.next = node;
        }

        // 尾插法
        public void addLast(int val){
            ListNode node = new ListNode(val);
            if (this.next == null){
                this.next = node;
            }else {
                ListNode cur = this.next;
                while (cur.next != null){
                    cur = cur.next;
                }
                cur.next = node;
            }
        }

        // 打印链表
        public void display(){
            ListNode cur = this;
            while (cur != null){
                System.out.print(cur.val + "\t");
                cur = cur.next;
            }
            System.out.println();
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode temp = cur;
        while (temp.next != null){
            if (temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return cur.next;
    }

    @Test
    public void test(){
        ListNode head = new ListNode(1);
        head.addLast(2);
        head.addLast(2);
        head.addLast(1);
        head.addLast(1);
        head.addLast(2);
        head.display();
        System.out.println();
        ListNode newNode = removeElements(head,1);
        newNode.display();
    }
}
