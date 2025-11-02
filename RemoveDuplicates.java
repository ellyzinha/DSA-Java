// Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
/*
input: nums = [1,1,2] -> Sorted
- Remove duplicates: nums = [1,2]
- The output it's going to be the size of the new array
output: 2

- HashMap -> Search O(1) - Not In Place
    - For to fill the hashmap with the values from the array and check the duplicates
    [] -> []
    - Insert the elements in the hash checking for duplicates;
    nums = [1,1,2]
              ^
    [1] -> [1]

    hash contains the value of the index that i'm checking?
        if yes, i don't add the element to the hash
        if no, i add the element

Example:

nums = [], output = 0
nums = [0], output = 1
Steps:

- Two Pointers (Slow and Fast)
    - Pointer start = nums[0] -> i++
    - Pointer end = nums[1] -> i++

    [1,1,2] i1 = i2 -> false; i++; i--; i3 = i3 then remove the element
       ^ ^

    [0,0,1,1,1,2,2,3,3,4] 0 = 4 -> false; i++; i--; 0 = 3 -> false; i++; i--
    ^ ^

*/
public class RemoveDuplicates {

    public int removeDuplicatesFun(int[] nums) {
        int listSize = nums.length;
        if(listSize == 0){
            return 0;
        }

        int pointer1 = 0;
        int pointer2 = 1;

        while (pointer2 < listSize){
            // [1,1,2] -> 1 == 1 true // 1 == 2
            if (nums[pointer1] != nums[pointer2]){
                pointer1++; // 2
                nums[pointer1] = nums[pointer2];
            }

            pointer2++; // 1
        }

        return pointer1 + 1;
    }


    /*
    remove some duplicates in-place such that each unique element appears at most twice.
    The relative order of the elements should be kept the same.

    Input: nums = [1,1,1,2,2,3]
    Output: 5, nums = [1,1,2,2,3,_]

    Check the length, return length if length is >= 2 because we allow maximum 2 duplicates

    Start from index 2 because we allow maximum 2 duplicates: current index i=2; checking index j=2;

    Check if current index element does not equal to the previous two element nums[i] != nums[j-2];

    Keep nums[i] if nums[i] != nums[j-2] is true: nums[j] = nums[i]; Increase j in order to keep it the same as i

    j is the valid length

     */
    public int removeDuplicates2(int[] nums) {
        int listSize = nums.length;
        if(listSize <= 2){
            return listSize;
        }

        int j = 2;

        for (int i = 2; i < listSize; i++){
            if (nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        System.out.println(removeDuplicates.removeDuplicatesFun(nums));
    }
}


