class Solution {
    static public int missingNumber(int[] nums) {
        boolean exist[] = new boolean[nums.length + 1];
        int ans = -1;
        for(int i = 0 ; i < nums.length; i++){
            exist[nums[i]] = true;
        }
        for(int i = 0 ; i <=nums.length ;i++){
            if(!exist[i]) ans = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {3,0,1};
        System.out.println(missingNumber(a));
    }
}