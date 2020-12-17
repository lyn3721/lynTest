public class Main {

    public static void main(String[] args) {

//        int[] arr = new int[20];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = i;
//        }
//        int[] scores = new int[]{10,99,66};
//        for (int i = 0; i <scores.length ; i++) {
//            System.out.println(scores[i]);
//        }
//
//        scores[0] = 100;
//        for (int score: scores) {
//            System.out.println(score);
//        }
//        Array<Integer> arr = new Array<Integer>(20);
//        for (int i = 0; i < 10; i++) {
//            arr.addLast(i);
//        }
//        System.out.println(arr);
//
//        arr.add(1,100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(0);
//        System.out.println(arr);
//
//        arr.removeFirst();
//        System.out.println(arr);
        Array<Integer> arr = new Array<>();
        for(int i = 0 ; i < 10 ; i ++)
            arr.addLast(i);
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9]
//
        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

}
