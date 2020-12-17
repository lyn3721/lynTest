public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public  Node(E e , Node next){
            this.e = e;
            this.next = next;
        }
        public  Node(E e){
            this.e = e;
            this.next = null;
        }
        public  Node(){
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyhead;
    int size;
    public LinkedList(){
        dummyhead = new Node(null,null);
        size = 0;
    }
    //获取与链表中的元素个数
    public int getSize(){
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }



    //在链表的index位置添加新的元素e
    //在链表中不是一个常用的操作，练习用

    public void add(int index,E e){
        if (index < 0 || index >size) {
            throw new IllegalArgumentException("失败，非法下标");
        }
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

//            prev.next = new Node(e,prev.next);
        size ++;

    }

    //在链表头添加新元素
    public void addFirst(E e){
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
//        head = new Node(e,head);
//        size ++;
        add(0,e);
    }

    //在链表尾部添加新的元素e
    public void addLast(E e){
        add(size,e);
    }

    //获得链表中得第index(0-based)个位置得元素
    //在链表中不失一个常用操作
    public E get(int index){
        if (index < 0 || index >size) {
            throw new IllegalArgumentException("失败，非法下标");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;

    }

    //获取链表第一个元素
    public E getFirst(){
        return get(0);
    }
    public E getLast(){
        return get(size-1);
    }

    //修改链表中得第index(0-based)个位置得元素
    //在链表中不失一个常用操作
    public void set(int index,E e){
        if (index < 0 || index >size) {
            throw new IllegalArgumentException("失败，非法下标");
        }
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //删除链表中得第index(0-based)个位置得元素
    //在链表中不失一个常用操作
    public  E remove(int index){
        if (index < 0 || index >size) {
            throw new IllegalArgumentException("失败，非法下标");
        }

        Node prev = dummyhead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;

        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.e;
    }

    //删除第一个与元素
    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }


    //查找链表中是否有元素e
    public boolean contains(E e){
        Node cur = dummyhead.next;
        while (cur != null){
            if (cur.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyhead.next;
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur = dummyhead.next; cur != null; cur = cur.next ){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        res.append("null");
        return res.toString();
    }
}
