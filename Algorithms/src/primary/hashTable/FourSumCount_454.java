package primary.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ausdin
 * @version 1.0
 */
public class FourSumCount_454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalCnt = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                int temp = i + j;
                map.compute(temp, (k, v) -> (v == null) ? 1 : v + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int temp = i + j;
//                for (int k : map.keySet()) {
//                    if (k == -temp) totalCnt += map.get(k);
//                } 这样O(N^2)了
                if (map.containsKey(-temp)) totalCnt += map.get(-temp);
            }
        }
        return totalCnt;
    }
}
