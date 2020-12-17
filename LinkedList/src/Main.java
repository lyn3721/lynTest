public class Main {

    public static void main(String[] args) {
	// write your code here

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);

        }
        linkedList.add(2,666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
