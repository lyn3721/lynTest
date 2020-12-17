public class LinkedListQueue<E> implements  Queue<E>{
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

    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean  isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("不能从空队列中出队！");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("队列为空！");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = head;
        res.append("Queue: front ");
        while (cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
//        for (Node cur = dummyhead.next; cur != null; cur = cur.next ){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        res.append("null tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 1; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }

    }

}
