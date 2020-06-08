/**
 * https://leetcode.com/problems/find-the-duplicate-number/
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package com.zea7ot.lc.lvl4.lc0287;

public class SolutionApproach0TwoPtrs {
    public int findDuplicate(int[] nums) {
        int tortoise = nums[0], hare = nums[0];
        
        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        }while(tortoise != hare);
        
        int ptr1 = nums[0], ptr2 = tortoise;
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        
        return ptr1;
    }
}