package structure.linkedList;

/**
 * 双向链表
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
public class MyLinkedList {

    //节点
    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }
    }

    private int size;
    //头尾
    private Node head, tail;

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        if (index == 0) {
            return head.val;
        } else {
            return getPrevNode(index).next.val;
        }

    }

    public void addAtHead(int val) {
        if (size == 0) {
            head = new Node(val);
            size++;
        } else {
            addAtIndex(0, val);
        }
    }

    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            size++;
        } else {
            addAtIndex(size, val);
        }
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }

        //插头
        if (index == 0) {
            if (size <= 0) {
                head = new Node(val);
                size++;
                return;
            }
            //size>0时
            Node node = new Node(val);

            head.prev = node;
            node.next = head;
            if (size == 1) {
                tail = head;
            }

            head = node;

            size++;
            return;
        }
        //插屁股
        if (index == size) {
            //一个元素时
            Node tailNode = new Node(val);
            if (size == 1) {
                head.next = tailNode;
                tailNode.prev = head;
                tail = tailNode;
                size++;
                return;
            } else {
                tailNode.prev = tail;
                tail.next = tailNode;
                tail = tailNode;
                size++;
                return;
            }
        }

        //正常插中间
        //获取目标节点的前驱节点
        Node prevNode = getPrevNode(index);
        Node node = new Node(val);

        node.next = prevNode.next;
        prevNode.next.prev = node;

        node.prev = prevNode;
        prevNode.next = node;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }

        if (size == 1) {
            head = null;
            size = 0;
            return;
        }
        Node prevNode = getPrevNode(index);
        //第一个节点
        if (index == 0) {
            if (size == 2) {
                tail.prev = null;
                head = tail;
            } else {
                //正常长度
                head = head.next;
                head.prev = null;
            }
        }
        //非最后一个节点
        else if (prevNode.next.next != null) {
            prevNode.next = prevNode.next.next;
            prevNode.next.prev = prevNode;
        } else {
            //最后一个节点
            prevNode.next = null;
            tail=prevNode;
        }

        size--;
    }

    //获取前驱节点
    private Node getPrevNode(int index) {
        //从前往后
        Node prevNode = null;
        for (int i = 0; i < index; i++) {
            if (i == 0) {
                prevNode = head;
            } else {
                prevNode = prevNode.next;
            }

        }
        return prevNode;
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
        System.out.println("s"+size);
    }
}
