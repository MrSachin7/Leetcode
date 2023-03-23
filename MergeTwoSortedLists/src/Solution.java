import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode nodeToStoreHead = new ListNode();       // A pointer pointing at an empty list
        ListNode currentPointer = nodeToStoreHead; // This pointer just points at the nodeToStoreHead

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                currentPointer.next = list1; // On the very first currentPointer.next = list1 / lis2 , also makes nodeToStoreHead point to list1 / list2,
                                             // But on other attempts only the currentPointer changes and not nodeToStoreThread.
                list1 = list1.next;
            }
            else {
                currentPointer.next = list2;
                list2 = list2.next;
            }
            // iterate next time for next element
            currentPointer = currentPointer.next;
        }

        // If either are null, the rest links should be from non null list
        if (list1 ==null){
            currentPointer.next = list2;
        }
        else{
            currentPointer.next = list1;
        }
        return nodeToStoreHead.next;
    }

    public static void main(String[] args) {


    }
}
