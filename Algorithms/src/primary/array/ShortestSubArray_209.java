package primary.array;

import static java.lang.Math.min;

/**
 * 滑动窗口，关键明白j是指向区间右端点
 * O(n)
 *
 * @author Ausdin
 * @version 1.0
 */
public class ShortestSubArray_209 {
    public static void main(String[] args) {
        int[] nums = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int target = 15;

        System.out.println(minSubArrayLen(target, nums));
        System.out.println(Integer.MAX_VALUE);

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int size = nums.length;
        int sum = 0;
        int res = 0;
        for (int i = 0, j = 0; j < size; j++) {
            sum += nums[j];
            while (sum >= target) {
                if (res == 0) res = j - i + 1;
                else res = min(j - i + 1, res); //注意最小值与首次赋值

                if (sum - nums[i] >= target) sum -= nums[i++];
                else break;
            }
        }
        return res;
    }

    // 滑动窗口
    public static int minSubArrayLenStandard(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1); // 通过max_value避免了我方法中的判断
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
