/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://leetcode.com/problems/palindrome-linked-list/discuss/64501/Java-easy-to-understand
 */
package com.zea7ot.lc.lvl3.lc0234;

import com.zea7ot.utils.data_structure.linkedlist.ListNode;

public class SolutionApproach0 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // to skip the node in the middle if the list contains odd number of nodes
        // odd nodes: let the right half smaller
        if(fast != null) slow = slow.next;
        slow = reverse(slow);
        fast = head;
        
        while(slow != null){
            if(fast.val != slow.val) return false;
            
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}