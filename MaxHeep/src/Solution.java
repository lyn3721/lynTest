

        import java.util.LinkedList;
        import java.util.TreeMap;

class Solution {
    public static int[] topKFrequent(int[] nums, int k) {

        class Freq implements Comparable<Freq>{
            int e,freq;


            @Override
            public int compareTo(Freq o) {
                if(this.freq < o.freq){
                    return 1;
                }else if(this.freq > o.freq){
                    return -1;
                }
                return 0;
            }

            public Freq(int em ,int freq){
                this.freq = freq;
                this.e = em;
            }
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num ,map.get(num) + 1);
            }else{
                map.put(num , 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            if(pq.getSize() < k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else if(map.get(key) > pq.getFront().e){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);

        int[] a = new int[pq.getSize()];
        for(int aa : a){
            aa = pq.dequeue().e;
        }
        return a;

    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        printList((new Solution()).topKFrequent(nums, k));
    }
    private static void printList(int[] nums){
        for(Integer num: nums)
            System.out.print(num + " ");
        System.out.println();
    }



}