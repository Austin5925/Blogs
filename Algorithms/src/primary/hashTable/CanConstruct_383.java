package primary.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ausdin
 * @version 1.0
 */
public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.compute(c, (k, v) -> v - 1);
            if (map.get(c) < 0) return false;
        }
        return true;
    }

    //标准解法开个数组，开销更小
    public boolean canConstructStandard(String ransomNote, String magazine) {
        // shortcut
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        // 定义一个哈希映射数组
        int[] record = new int[26];

        // 遍历
        for(char c : magazine.toCharArray()){
            record[c - 'a'] += 1;
        }

        for(char c : ransomNote.toCharArray()){
            record[c - 'a'] -= 1;
        }

        // 如果数组中存在负数，说明ransomNote字符串总存在magazine中没有的字符
        for(int i : record){
            if(i < 0){
                return false;
            }
        }

        return true;
    }
}
