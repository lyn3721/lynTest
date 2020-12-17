public class MaxHeep<E extends Comparable<E>> {

    private Array<E> data;


    public MaxHeep(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeep(){
        data = new Array<>();
    }

    public MaxHeep(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(data.getSize()-1); i >= 0 ; i--) {
            siftDown(i);
        }
    }


    //返回堆中元素
    public int size(){
        return data.getSize();
    }

    //判断堆是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    //返回完全二叉树数组表示中一个索引所表示的父亲节点的索引
    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index dosen't have parent");
        }
        return (index - 1) / 2 ;
    }

    //返回完全二叉树数组表示中一个索引所表示的左孩子节点的索引
    private int leftchild(int index){
//        if(index == 0){
//            throw new IllegalArgumentException("index dosen't have leftchild");
//        }
        return index * 2 + 1 ;
    }

    //返回完全二叉树数组表示中一个索引所表示的右孩子节点的索引
    private int rightchild(int index){
//        if(index == 0){
//            throw new IllegalArgumentException("index dosen't have rightchild");
//        }
        return index * 2 + 2 ;
    }

    // 向堆中添加元素
    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
            data.swap(k,parent(k));
            k = parent(k);
        }
    }

    public E findMax(){
        if(data.getSize() == 0){
            throw new IllegalArgumentException("Can't findMax when heep is null");
        }
        return data.get(0);
    }

    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int index){

        while (leftchild(index) < data.getSize()){
            int j = leftchild(index);
            if(j + 1 < data.getSize() && data.get(j+1).compareTo(data.get(j))>0 ){
                j = rightchild(index);
            }
            //data.get(j) 是 leftchild 和 rightchild 中最大值

            if(data.get(index).compareTo(data.get(j)) > 0 ){
                break;
            }

            data.swap(index,j);
            index = j;

        }
    }

    //去除堆中最大值并替换成元素e
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }
}


