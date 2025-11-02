import java.sql.Array;

public class PrefixSum {

    public int[] PrefixSumMethod(int[] nums){
        // [2,4,6,8,10]
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        // [0] = 2

        // i = 1
        // 1 < 5
        for (int i = 1; i < nums.length; i++){
            // [] = 2 + 4 // [2,6]
            // i = 2 //[2,6,i] = 6 + 6 // [2,6,12]
            // i = 3 //[2,6,12,i] = 12 + 8 // [2,6,12,20]
            // i = 4 // [2,6,12,20,i] = 20 + 10 // [2,6,12,20,30]
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        return prefixSum;
    }


    public static void main(String[] args) {
        int[] nums = {2,4,6,8,10};
        PrefixSum prefixSum = new PrefixSum();
        prefixSum.PrefixSumMethod(nums);

    }
}
