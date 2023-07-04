package primary.hashTable;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Ausdin
 * @version 1.0
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length < 2) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) { // how to deal with the boundary
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static int[] twoSumWrong(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key: num, value: index
        int cnt = 0;
        for (int i : nums) {
            int temp = target - i;
            if (map.isEmpty()) {
                map.put(i, cnt++);
                continue;
            }
            if (temp == i ) { //考虑[3,3],6
                int[] arr = new int[2];
                arr[0] = map.get(i);
                arr[1] = map.get(i) + 1;
                return arr;
            } else {
                map.put(i, cnt++);
            }
            if (map.size() == 1) continue;

            for (int j : map.keySet()) {
                int[] arr = new int[2];
                arr[0] = map.get(j);
                arr[1] = map.get(i);
                if (j == temp) return arr;
            }
        }
        return null;
    }

    public int[] twoSumStandard(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key
            if(map.containsKey(temp)){ //containsKey method
                res[1] = i;
                res[0] = map.get(temp);
                break;
            }
            map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        System.out.println(twoSum(nums, 6));
    }
}
