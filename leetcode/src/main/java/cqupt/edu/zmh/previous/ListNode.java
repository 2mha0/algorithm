package cqupt.edu.zmh.previous;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // tail作为尾巴拼接到this的后面
    public void concat(ListNode tail){
        ListNode head = this;
        while (head.next != null){
            head = head.next;
        }
        head.next = tail;
    }

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

    // 获取单链表的长度(不算上头节点)
    public int size(){
        int size = 0;
        ListNode cur = this.next;
        while (cur != null){
            size++;
            cur = cur.next;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.addFirst(3);
        head.addFirst(4);
        head.addFirst(5);
        head.display();
        int size = head.size();
        System.out.println(size);
    }
}
