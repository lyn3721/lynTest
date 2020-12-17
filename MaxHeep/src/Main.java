import java.util.Random;

public class Main {

    private static double testheap(Integer[] arr, boolean isHeapify){
        long starttime = System.nanoTime();
        MaxHeep<Integer> maxHeep;
        if(isHeapify){
            maxHeep = new MaxHeep<>(arr);
        }else{
            maxHeep = new MaxHeep<>();
            for (Integer i : arr){
                maxHeep.add(i);
            }
        }

        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = maxHeep.extractMax();
        }

        for (int i = 1; i < arr.length; i++) {
            if(nums[i-1] < nums[i]){
                throw new IllegalArgumentException("error");
            }

        }
        System.out.println("Test Maxheep Completed!");
        long endtime = System.nanoTime();

        return (endtime - starttime) / 1000000000.0;
    }

    public static void main(String[] args) {
//        int n = 1000000;
//        Random random = new Random();
//        MaxHeep<Integer> maxHeep = new MaxHeep<>();
//
//        for (int i = 0; i < n; i++) {
//            maxHeep.add(random.nextInt(Integer.MAX_VALUE));
//        }
//
//        int[] nums = new int[n];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = maxHeep.extractMax();
//        }
//
//        for (int i = 1; i < n; i++) {
//            if(nums[i-1] < nums[i]){
//                throw new IllegalArgumentException("error");
//            }
//
//        }
//        System.out.println("Test Maxheep Completed!");

//        int n = 10000000;
//        Random random = new Random();
//        Integer[] nums = new Integer[n];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = random.nextInt(Integer.MAX_VALUE);
//        }
//
//        double time1 = testheap(nums,false);
//        System.out.println("without heapify: " + time1 + "s");
//
//        double time2 = testheap(nums,true);
//        System.out.println("with heapify: " + time2 + "s");



    }
}
