package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int[] twoSum(int[] nums, int target) {
        // set the length of the list to a variable n
        int n=nums.length;
        // make a hashmap of int,int
        Map<Integer,Integer> map=new HashMap<>();
        // make a list of ints called result with size of 2
        // because the result should be two indexes
        int[] result=new int[2];
        // loop from 0 to the length of the nums list
        for(int i=0;i<n;i++){
            // if the hashmap has a key to add to the current value
            // which would make the target value
            if(map.containsKey(target-nums[i])){
                System.out.println("found it");
                // then you found them
                result[1]=i;
                // .get returns the key which is the index
                result[0]=map.get(target-nums[i]);
                // return the result which is a list of the two indexes
                return result;
            }
            // you didn't find it yet, so set
            System.out.println("didn't find it");
            System.out.println("nums[i]");
            System.out.println(nums[i]);
            System.out.println("i");
            System.out.println(i);
            map.put(nums[i],i);
        }
        return result;
    }

    public static boolean isValid(String s) {
        // make a Stack of characters called stack
        Stack<Character> stack = new Stack<Character>();
        // iterate over each character in the passed-in string which
        // is cast to an array
        for (char c : s.toCharArray()) {
            // if (
            if (c == '(')
                // close it in the future with )
                stack.push(')');
            // if {
            else if (c == '{')
                // close it in the future with }
                stack.push('}');
            // if [
            else if (c == '[')
                // close it in the future with ]
                stack.push(']');
            // pop the top item of the stack and see if it matches
            // the current character
            else if (stack.isEmpty() || stack.pop() != c)

                return false;
        }
        return stack.isEmpty();
    }

    public static int romanToInt(String s) {
        // make a hashmap called m
        Map<Character, Integer> m = new HashMap<>();
        // add a key of char and a value of int
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);

        // set up the ans at 0
        int ans = 0;

        // loop over the string
        for (int i = 0; i < s.length(); i++) {
            // don't look at the last item, compare current value with next value
            if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i + 1))) {
                // since next was greater than current, subtract from the answer
                ans -= m.get(s.charAt(i));
            } else {
                // since current was greater than next, add to the answer
                // (this also happens if we are looking at the last item)
                ans += m.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // start at the beginning
        ListNode current = head;
        // as long as current isn't null and next isn't null
        while (current != null && current.next != null) {
            // if current is equal to next
            if (current.val == current.next.val) {
                // remove reference to next
                // take next's next as your next
                current.next = current.next.next;
            } else {
                // move on
                current = current.next;
            }
        }

        return head;
    }
    public static void main(String[] args) {
//        System.out.println("Hello world!");
//        int[] nums = {3,2,4};
//        int target = 6;
//        System.out.println(Arrays.toString(twoSum(nums, target)));

//        String s = "(]";
//        System.out.println(isValid(s));

//        String s = "MCMXCIV";
//        System.out.println(romanToInt(s));
        //[1,1,2,3,3]
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(1);
        head.next = second;
        ListNode third = new ListNode(2);
        second.next = third;
        ListNode fourth = new ListNode(3);
        third.next = fourth;
        ListNode fifth = new ListNode(3);
        fourth.next = fifth;
        ListNode current = head;
        deleteDuplicates(head);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }

    }
}