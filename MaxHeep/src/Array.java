public class Array<E> {
//表示任意数据类型E
    private E[] data;
    private int  size;

    /**
     *  构造函数 传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    //无参数的构造函数 默认数组的容量capacity=10
    public  Array(){
        this(10);
    }

    public  Array(E[] arr) {
        data  = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    //获取数组的个数
    public int getSize(){
        return size;
    }
    //获取数组的容量
    public  int getCapacity(){
        return data.length;
    }
    //返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素后添加一个元素
    public void  addLast(E e){
//        if(size == data.length){
//            throw new IllegalArgumentException("AddLast failed,Array is full.");
//        }
//        data[size] = e;
//        size ++;

        add(size,e);
        //data[size++] = e;
    }

    //向所有元素前添加一个元素
    public void addFirst(E e){
        add(0,e);
    }

    //向指定位置添加元素
    public void add(int index ,E e){


        if (index < 0 || index > size){
            throw new IllegalArgumentException("AddLast failed,require index >= 0 and index <size.");
        }

        if(size == data.length){
//            throw new IllegalArgumentException("AddLast failed,Array is full.");
            //扩容
            resize(2 * data.length);
        }


        for (int i = size-1 ; i >=index ; i --){
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;

    }

    //获取index索引位置的元素
    public E get(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("失败，索引超过范围");
        return data[index];
    }

    //查找元素是否有e
    public Boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] .equals(e) ){
                return true;
            }
        }
        return false;
    }

    //查找元素是否有e,如果不存在返回-1
    public int find(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] .equals(e) ){
                return i;
            }
        }
        return -1;
    }

    //删除index位置元素 返回删除元素
    public E remove(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("失败，索引超过范围");

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        //因为size指向两个引用对象 将多余的置空 loitering objects != 内存泄露
//        data[size] = null;

        if(size == data.length / 4 && data.length / 2 != 0 ) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size-1);
    }

    //从数组删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);

    }

    //修改index索引位置的元素为e
    void set(int index , E e){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("失败，索引超过范围");
        data[index] = e;
    }

    public void swap(int i , int k ){
        if (i < 0 || i >= size || k < 0 || k >= size){
            throw new IllegalArgumentException("array is illage");
        }
        E e = data[i];
        data[i] = data[k];
        data[k] = e;

    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("数组，长度 = %d , 容量 = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size-1){
                res.append(", ");
            }

        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];

        }
        data = newData;
    }
}
