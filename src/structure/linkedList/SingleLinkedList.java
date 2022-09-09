package structure.linkedList;

/**
 * 单向链表
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class SingleLinkedList {
    //节点
    private class Node {
        int val;
        Node next = null;

        public Node(int val) {
            this.val = val;
        }
    }

    //头节点
    private Node head;
    private int size;

    //构造
    public SingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size || head == null) {
            return -1;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    //头部添加
    public void addAtHead(int val) {
        Node node = new Node(val);
        if (this.head != null) {
            Node firstNode = node;
            firstNode.next = this.head;
            this.head = firstNode;
            this.size++;
        } else {
            this.head = new Node(val);
            this.size++;
        }
    }

    //尾部添加
    public void addAtTail(int val) {
        if (size == 0) {
            this.head = new Node(val);
            head.next = null;
            this.size++;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node tail = new Node(val);
            temp.next = tail;
            tail.next = null;
            this.size++;
        }

    }

    //中间添加
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        //处理中间插入的情况
        Node temp = this.head;

        //遍历到指定位置
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        this.size++;

    }


    //中间删除
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        //换头
        if (index == 0) {
            //判断下头有没有
            if (this.size != 1) {
                Node temp = this.head.next;
                this.head = temp;
                size--;
                return;
            } else {
                this.head = null;
                this.size--;
                return;
            }
        }
        Node temp = this.head;
        //中间删除需要找到删除节点的上一个节点和下一个节点
        //获取删除节点前一个节点
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        //删除节点
        Node delNode = temp.next;
        //删除节点下一个节点
        Node ne = delNode.next;
        temp.next = ne;
        this.size--;
    }

    public void printLinkedList() {
        StringBuffer sb = new StringBuffer();
        Node temp = head;
        if (head == null) {
            System.out.println(" ");
            return;
        }
        sb.append(head.val + " ");
        while (temp.next != null) {
            temp = temp.next;
            sb.append(temp.val + " ");
        }
        System.out.println(sb);
    }
}