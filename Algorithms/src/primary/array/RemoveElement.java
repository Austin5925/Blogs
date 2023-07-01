package primary.array;

/**
 * 暴力法、双指针法、相对双指针法
 * @author Ausdin
 * @version 1.0
 */
public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
        int val = 4;

        removeElement2(nums, val);

    }

    public static int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < size; j++) { // 注意j的初值
                    nums[j - 1] = nums[j]; // 注意数组越界
                }
                size--;
                i--;
            }
        }
        return size;
    }

    public static int removeElement2(int[] nums, int val) {
        int size = nums.length;
            
        return size;
    }
}
