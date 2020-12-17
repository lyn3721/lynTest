public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeep<E> maxHeep;

    public PriorityQueue(){
        maxHeep = new MaxHeep<>();
    }
    @Override
    public int getSize() {
        return maxHeep.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeep.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeep.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeep.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeep.findMax();
    }
}
