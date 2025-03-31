import java.math.BigInteger;

class Solution {
    public String solution(String a, String b) {
        BigInteger aValue = new BigInteger(a);
        BigInteger bValue = new BigInteger(b);
        BigInteger sum = aValue.add(bValue);
        return sum + "";
    }
}