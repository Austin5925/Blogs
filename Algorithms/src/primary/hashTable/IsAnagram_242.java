package primary.hashTable;

import java.util.HashMap;

/**
 * 首先暴力法O(n^2)
 * 其次字典解法
 * 时间复杂度O(m+n) 空间复杂度O(1)
 *
 * @author Ausdin
 * @version 1.0
 */
public class IsAnagram_242 {

    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else map.put(c, map.get(c) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            } else map.put(c, map.get(c) - 1);
        }
        for (char c : map.keySet()) {
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagramStandard(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }

    public static void main(String[] args) {

    }
}
