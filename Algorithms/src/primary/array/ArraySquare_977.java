package primary.array;

import java.util.Arrays;

/**
 * #977
 * 暴力法O(nlogn)
 * 同样双指针法 O(n)
 * @author Ausdin
 * @version 1.0
 */
public class ArraySquare_977 {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
        int headIndex = 0, tailIndex = nums.length - 1;
        int[] array = new int[nums.length];
        int i = 0;

        while (headIndex <= tailIndex) {
            if (Math.abs(nums[headIndex])> Math.abs(nums[tailIndex])) {
                array[i++] = (int) Math.pow(nums[headIndex++], 2);
            } else {
                array[i++] = (int) Math.pow(nums[tailIndex--], 2);
            }
        }
        //另外，把数组i直接等于tail，然后--，就完事了，不用反转。我傻逼了。
        int[] array2 = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            array2[nums.length - j - 1] = array[j]; //注意数组边界 ： -1
        }

        return array2;
    }

}
