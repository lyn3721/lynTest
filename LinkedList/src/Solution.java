class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head ;
        ListNode prew = head;
        while(prew.next!=null){
            if(prew.next.val == val){
                prew.next = prew.next.next;
            }else{
                prew = prew.next;
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res =  (new Solution()).removeElements(head,6);
        System.out.println(res);
    }
}