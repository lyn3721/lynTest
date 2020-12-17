import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }



    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(K key, V value){
        root =  add(root,key,value);
    }

    @Override
    public boolean contains(K key){
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }


    @Override
    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }




    //向以node为根的二分搜索树插入元素(key,value)，递归算法
    //返回插入新节点的二叉树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        return node;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    private Node minmum(Node node){
        if (node.left == null) {
            return node;
        }
        return minmum(node.left);
    }


    //删除以node 为根二分搜索树中的最小节点
    //返回删除节点后二分搜索树的跟

    private Node removeMin (Node node){
        if (node.left == null) {
            Node rightnode = node.right;
            node.right = null;
            size--;
            return rightnode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){
            root = remove(root,key);
            return node.value;
        }

        return null;
    }
    //删除以node为根的二分搜索树中值为key 的节点，递归算法
    //返回删除后新的二叉树的跟
    private Node remove(Node node , K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {//compareTo(node.key) == 0
            //待删除结点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            //待删除节点右子树为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            //待处理左右子树均不为空的情况
            //找到比待删除的节点大的最小节点，即待删除节点右子树的最小节点
            //用这个节点代替待删除节点的位置
            Node successor = minmum(node.right);
            System.out.println(successor.key);

            successor.right = removeMin(node.right);
            System.out.println(successor.right.key);

            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }



    }


    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
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
