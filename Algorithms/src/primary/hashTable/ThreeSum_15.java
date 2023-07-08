package primary.hashTable;

import java.util.*;

/**
 * 哈希法不推荐
 * 最好使用双指针法
 * @author Ausdin
 * @version 1.0
 */
public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {  // 去重a
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
                    while (right > left && nums[right] == nums[right - 1]) right--;
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSumHash(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue;
                int temp = nums[i] + nums[j];
                map.compute(temp, (k, v) -> (v == null) ? 1 : v + 1);
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[j]);
                resList.add(list);
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (map.containsKey(-nums[k])) {
                for (List<Integer> res : resList) {

                }
            }
        }

        return resList;
    }
}
