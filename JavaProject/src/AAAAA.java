public class AAAAA{
    public static double recursive(int i){
        int sum = 0;
        while(i>0){
            sum += i * i;
            i -- ;
            recursive(i-1);
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(new AAAAA().recursive(6));
    }
}

