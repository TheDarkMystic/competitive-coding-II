package Arrays;

import java.util.Arrays;

/**
 * @author jakadam on 2020-01-06
 */

/**
 * Given an array of integers, sort the array into a wave like array and return it,
 * In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....
 *
 * Example
 *
 * Given [1, 2, 3, 4]
 *
 * One possible answer : [2, 1, 4, 3]
 * Another possible answer : [4, 1, 3, 2]
 *  NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
 * So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    public static void main(String[] args) {
        int[] nums={4, 2, 3, 1};
        System.out.println(Arrays.toString(waveArray(nums)));
    }

    /**
     * sorting is to get the lexicographically first part right, otherwise not needed
     * Logic is simple
     * 1. if ele at even index is < than its prev ele, swap them
     * 2. if ele at odd index is > than its prev ele, swap them
     * @param nums
     * @return
     */
    public static int[] waveArray(int[] nums){

        Arrays.sort(nums);

        for(int i=1; i<nums.length; i++){
            if(i%2==0 && nums[i-1]>nums[i])
                swap(nums, i-1,i);
            if(i%2==1 && nums[i-1]<nums[i])
                swap(nums, i-1, i);

        }

        return nums;
    }

    public static int[] swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

        return nums;
    }
}
