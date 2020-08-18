/**
 * https://leetcode.com/problems/132-pattern/
 * 
 * Time Complexity: O(N), one pass
 * Space Complexity: O(N)
 * 
 * to maintain a strickly decreasing stack:
 *  1. the elements are values, instead of indexes
 *  2. the order of the elements is strictly decreasing,
 *      meaning that nce any bigger value is pushed into the stack, all smaller values are poped out,
 *      meaning that only smaller values can be pushed into the stack directly, without popping out any element
 * 
 * key step 1: 
 *  elements recently popped out is guaranteed to be smaller than the elements in the stack,
 *  so the elements popped out become the candidates for s3, 
 *  and the elements in the stack become the candidates for s2.
 * key step 2: 
 *  after key step 1 is satified, meaning there are candidates for both s2 and s3, 
 *  once s1 can be found, it is the time to return true
 */
package com.zea7ot.leetcode.lvl4.lc0456;

import java.util.Stack;

public class SolutionApproachStack {
    public boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = nums.length - 1; i >= 0; i--){
            // key step 2
            if(nums[i] < s3) return true;
            else{
                while(!stack.isEmpty() && nums[i] > stack.peek()){
                    // key step 1
                    s3 = stack.pop();
                }
            }


            stack.push(nums[i]);
        }
        
        return false;
    }
}