import java.util.*;

// https://leetcode.com/problems/majority-element/description/?source=submission-ac

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> listMajority = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if (!listMajority.containsKey(nums[i])){
                listMajority.put(nums[i],0);
            }
        }

        for (int i = 0; i < nums.length; i++){
            int value = listMajority.get(nums[i]);
            if (listMajority.containsKey(nums[i])){
                listMajority.put(nums[i], ++value);
            }
        }

        listMajority.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        //check which element has the highest value
        Map.Entry<Integer, Integer> maxEntry = Collections.max(listMajority.entrySet(),
                Map.Entry.comparingByValue());

        int majorityElement = maxEntry.getKey();

        return majorityElement;
    }

    public static void main(String[] args) {
        int[] nums =  {2,2,1,1,1,2,2};

        MajorityElement majorityElement = new MajorityElement();
        int result = majorityElement.majorityElement(nums);

        System.out.println(result);
    }
}
