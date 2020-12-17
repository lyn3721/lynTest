import java.util.Random;

public class Main {

    private  static double testQueue(Queue<Integer> q,int opCount){
        long Starttime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endtime = System.nanoTime();
        return (endtime - Starttime) / 1000000000.0;
     }
    public static void main(String[] args) {
//	    ArrayQueue<Integer> array = new ArrayQueue<Integer>();
//	    double time1 = testQueue(array,100000);
//	    System.out.println(time1);

        LoopQueue<Integer> array1 = new LoopQueue<Integer>();
        double time2 = testQueue(array1,10000000);
        System.out.println(time2);

        LinkedListQueue<Integer> array3 = new LinkedListQueue<Integer>();
        double time3 = testQueue(array3,10000000);
        System.out.println(time3);
    }
}
