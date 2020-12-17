import java.util.Random;
import java.util.Stack;
public class Main {

    //测试使用stack运行opcount个push and pop操作所需要的时间 单位miao

    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<Character>() ;
        for(char a : S.toCharArray()){
            if(stack.isEmpty() || stack.peek()!= a){
                stack.push(a);
            }else{
                stack.pop();
            }
        }
        for (char a : stack){
            String.valueOf(a);
        }
        return stack.toString();
    }

    public static void main(String[] args) {
//        int opCount = 10000000;
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        Double time1 = testStack(arrayStack, opCount);
//
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        Double time2 = testStack(linkedListStack, opCount);
//
//        System.out.println("ArrayStack: " + time1 + "LinkedListStack: " + time2);
        //其实这个时间比较很复杂因为链表栈中包含更多new操作

       String a =  removeDuplicates("aabbcaf");
        System.out.println(a);
    }


}

