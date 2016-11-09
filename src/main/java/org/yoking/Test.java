package org.yoking;


public class Test {

	public static void main(String[] args) {
		int i = 2, j = 3;
		
		i ^= j;	// i = i ^ j;
		j ^= i;	// j = j ^ (i ^ j) = i;
		i ^= j; // i = (i ^ j) ^ i = j;
		System.out.println("i="+i+", j="+j);
		
		System.out.println(returnValue());
	}
	
	public static int returnValue() {
		int ret = 0;
		try {
			throw new Exception();
		} catch (Exception e) {
			ret = 1;
			return ret;
		} finally {
			ret = 2;
		}
	}
	
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1; j<nums.length;j++) {
                if(nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }
}