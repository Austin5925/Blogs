package primary.array;

/**
 * 定好固定的截取条件：左闭右开
 *
 * @author Ausdin
 * @version 1.0
 */
public class SpiralMatrix_59 {
    public static void main(String[] args) {
        int n = 11;
        int[][] matrix = generateMatrix(n);
        for (int[] ints : matrix) {
            System.out.println(java.util.Arrays.toString(ints));
        }
    }

    public static int[][] generateMatrix(int n) {
        int startX = 0, startY = 0;
        int index = 1;
        int[][] arr = new int[n][n];
        while ( n >> 1 > 0) { // 在标准解法中，不改变n的值是更好的
            int i = startX, j = startY;
            for (; j < startX + n - 1; j++){ //注意要-1
                arr[i][j] = index++;
            }
            for (; i < startY + n - 1; i++){
                arr[i][j] = index++;
            }
            for (; j > startX; j--) {
                arr[i][j] = index++;
            }
            for (; i > startY; i--) {
                arr[i][j] = index++;
            }
            n -= 2;
            startX++;
            startY++;
        }

        if (n % 2 == 1) { //考虑奇数情况，中间一个
            arr[startX][startY] = index;
        }
        return arr;
    }
}
