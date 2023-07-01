package primary.array;

/**
 * @author Ausdin
 * @version 1.0
 */
public class Dichotomy {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 4;
        int left = 0, right = nums.length;
        while (left < right ) {
            int middle = (left + right) >> 1;
            if (nums[middle] > target)
                right = middle;
            else if (nums[middle] < target)
                left = middle + 1;
            else if (nums[middle] == target) {
                System.out.println(middle);
                return;
            }
        }
    }
}
