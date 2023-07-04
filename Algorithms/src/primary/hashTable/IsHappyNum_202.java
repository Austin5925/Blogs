package primary.hashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ausdin
 * @version 1.0
 */
public class IsHappyNum_202 {
    public static boolean isHappy(int n) {
        if (n <= 0) return false;
        Set<Integer> set = new HashSet<>(); //detect cycles
        List<Integer> list = new ArrayList<>();
        set.add(n);
        updateList(n, list);
        while (true) {
            int sum = 0;
            for (int i : list) {
                sum += i * i;
            }
            if (sum == 1) return true;
            if (set.add(sum) == false) return false; // cycle appears
            updateList(sum, list);
        }
    }

    public static void updateList(int n, List list) {
        list.clear();
        while (n > 0) {
            int temp = n % 10;
            n /= 10;
            list.add(temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public boolean isHappyStandard(int n) { // so brief and elegant
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumberStandard(n);
        }
        return n == 1;
    }

    private int getNextNumberStandard(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
