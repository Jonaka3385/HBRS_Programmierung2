package projekt_euler;

// Largest Palindrome Product
// https://projekteuler.de/problems/4
// https://projecteuler.net/problem=4
public class Euler004 {
    public static int[] method(int l){
        int startwert = (int) Math.pow(10, l-1);
        int endwert = ((int) Math.pow(10, l)) - 1;
        int a = 0;
        int b = 0;
        int s = 0;
        int tmp;

        for (int i = startwert; i <= endwert; i++){
            for (int j = startwert; j <= endwert; j++){
                tmp = i * j;
                if (isPalindrome(tmp) && tmp > s){
                    s = tmp;
                    a = i;
                    b = j;
                }
            }
        }

        int[] result = new int[3];
        result[0] = a;
        result[1] = b;
        result[2] = s;
        return result;
    }

    private static boolean isPalindrome(int integer) {
        String intStr = String.valueOf(integer);
        return intStr.contentEquals(new StringBuilder(intStr).reverse());
    }
}
