class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
       if(head == null){
           return null;
       }
       head.next = removeElements(head,val);
       return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res =  (new Solution()).removeElements(head,6);
        System.out.println(res);
    }
}