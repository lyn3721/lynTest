import java.util.ArrayList;

public class LinkedListMap<K,V> implements Map<K,V> {
    private class Node{

        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key){
            this(key,null,null);
        }
        public  Node(){
            this(null,null,null);
        }

        @Override
        public String toString(){
            return key.toString() + " ：" + value.toString();
        }
    }


    private Node dummyhead;
    int size;
    public LinkedListMap(){
        dummyhead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            dummyhead.next = new Node(key,value,dummyhead.next);
            size ++;
        }else{
            node.value = value;
        }

    }

    @Override
    public V remove(K key) {
        Node cur = dummyhead;
        while(cur.next != null){
            if(cur.next.key.equals(key)){
                break;
            }else{
                cur = cur.next;
            }
        }
        if(cur.next != null){
            Node delNode = cur.next;
            cur.next = delNode.next;
            delNode.next = null;
            size --;
            return delNode.value;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }


    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(key);
        if(node == null){
            throw new IllegalArgumentException("dosen't exsit!");
        }
        node.value = value;

    }


    //获取与链表中的元素个数
    public int getSize(){
        return size;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    private Node getNode(K key){
        Node cur = dummyhead.next;
        while(cur != null){
            if(cur.key.equals(key)){
                return cur;
            }else{
                cur = cur.next;
            }
        }
        return null;
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            LinkedListMap<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }


}
