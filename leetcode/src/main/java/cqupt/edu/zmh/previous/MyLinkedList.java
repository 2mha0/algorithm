package cqupt.edu.zmh.previous;

import org.junit.Test;

// 这题头节点不存val
public class MyLinkedList {
    public int val;
    MyLinkedList next;
    public MyLinkedList() {

    }

    // get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index) {
        if (index < 0) return -1;
        MyLinkedList head = this;
        for (int i = 0; i <= index; i++) {
            if (head.next != null){
                head = head.next;
            }else {
                return -1;
            }
        }
        return head.val;
    }

    // addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
    public void addAtHead(int val) {
        MyLinkedList head = this;
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        node.next = head.next;
        head.next = node;
    }

    // addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素
    public void addAtTail(int val) {
        MyLinkedList head = this;
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        while (head.next != null){
            head = head.next;
        }
        head.next = node;
    }

    // addAtIndex(index,val)：在链表中的第index个节点之前添加值为val的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
    // 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点
    public void addAtIndex(int index, int val) {
        MyLinkedList head = this;
        MyLinkedList node = new MyLinkedList();
        node.val = val;
        if (index >= 0) {
            for (int i = 0; i < index; i++) {
                if (head.next == null) return;
                head = head.next;
            }
        }
        node.next = head.next;
        head.next = node;
    }

    // deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点
    public void deleteAtIndex(int index) {
        MyLinkedList head = this;
        for (int i = 0; i < index; i++) {
            if (head.next == null)
                return;
            head = head.next;
        }
        if (head.next == null)
            return;
        head.next = head.next.next;
    }

    @Test
    public void test(){
        MyLinkedList head = new MyLinkedList();
        head.addAtHead(1);
        head.addAtTail(3);
        head.addAtIndex(1,2);
        head.get(1);
        head.deleteAtIndex(1);
        head.get(1);
        head.get(3);
        head.deleteAtIndex(3);
        head.deleteAtIndex(0);
        head.get(0);
        head.deleteAtIndex(0);
        head.get(0);
    }
}
