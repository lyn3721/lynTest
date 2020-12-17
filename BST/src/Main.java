import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
//        int nums[] = {5,3,6,8,4,2};
//        for (int num : nums){
//            bst.add(num);
//        }


//        bst.preOrder(); //前序遍历
//        System.out.println();
//        bst.preOrderNR();//前序遍历非递归
//        bst.levelOrder();//层序遍历
//        bst.inOrder();//中序遍历
//        bst.postOrder();//后序遍历
//        System.out.println();
//        System.out.println(bst);

        int n = 100;
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bst.add(new Random().nextInt(10000));
        }
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if(nums.get(i-1) > nums.get(i)){
                throw new IllegalArgumentException("error");
            }

        }
        System.out.println("success!");


//        while(!bst.isEmpty()){
//            nums.add(bst.removeMax());
//        }
//        System.out.println(nums);
//        for (int i = 1; i < nums.size(); i++) {
//            if(nums.get(i-1) > nums.get(i)){
//                throw new IllegalArgumentException("error");
//            }
//
//        }
//        System.out.println("success!");
    }
}
