package primary.array;

/**
 * #27
 * 暴力法、双指针法、相对双指针法
 *
 * @author Ausdin
 * @version 1.0
 */
public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 4, 8, 9};
        int val = 4;


        System.out.println("size: " + removeElement2(nums, val));
        System.out.println("nums: " + java.util.Arrays.toString(nums));

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
        int slowIndex = 0; // slowIndex写外面
        for (int fastIndex = 0; fastIndex < size; fastIndex++) { // 注意fastIndex的意义
            if (nums[fastIndex] != val) {
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex; // 注意返回值
    }

    public int removeElement3(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while(right >= 0 && nums[right] == val) right--; //将right移到从右数第一个值不为val的位置
        while(left <= right) {
            if(nums[left] == val) { //left位置的元素需要移除
                //将right位置的元素移到left（覆盖），right位置移除
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
}
