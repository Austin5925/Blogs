package primary.string;

/**
 * @author Ausdin
 * @version 1.0
 */
public class ReverseStringV2_541 {
    public static String reverseStr(String s, int k) {
        if (k <= 0) return null;
        int iter = s.length() / k; //此种方式如果iter=0则不行
        char[] sArray = s.toCharArray();
        for (int i = 0; i < iter; i++) {
            int initialPos = i * k * 2;
            int endPos = Math.min(s.length() - 1, initialPos + k - 1);
            //用异或运算反转
            while(initialPos < endPos){
                  // convert String to char array
                sArray[initialPos] ^= sArray[endPos];
                sArray[endPos] ^= sArray[initialPos];
                sArray[initialPos] ^= sArray[endPos];
                  // convert char array back to String
                initialPos++;
                endPos--;
            }
        }
        String result = new String(sArray);
        return result;
    }

    public String reverseStrStandard1(String s, int k) {
        StringBuffer res = new StringBuffer();
        int length = s.length();
        int start = 0;
        while (start < length) {
            // 找到k处和2k处
            StringBuffer temp = new StringBuffer();
            // 与length进行判断，如果大于length了，那就将其置为length
            int firstK = (start + k > length) ? length : start + k;
            int secondK = (start + (2 * k) > length) ? length : start + (2 * k);

            //无论start所处位置，至少会反转一次
            temp.append(s.substring(start, firstK));
            res.append(temp.reverse());

            // 如果firstK到secondK之间有元素，这些元素直接放入res里即可。
            if (firstK < secondK) { //此时剩余长度一定大于k。
                res.append(s.substring(firstK, secondK));
            }
            start += (2 * k);
        }
        return res.toString();
    }

    public String reverseStrStandard2(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1, start + k - 1);
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }

    public String reverseStrStandard3(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 8));
    }
}
