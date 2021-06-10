import java.util.Arrays;

class SingleNumber2 {
    static public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        else if(nums[nums.length -1] != nums[nums.length-2]) return nums[nums.length -1];
        for(int i = 1 ; i < nums.length-1 ; i++){
            if(nums[i-1] != nums[i] && nums[i] != nums[i+1]) return nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {30000,500,100,30000,100,30000,100};
        System.out.println(singleNumber(nums));
    }
}