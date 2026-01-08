public class HappyNumber {

    // Helper method to calculate the sum of the squares of digits
    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    // LeetCode method signature: check if a number is a happy number
    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);

        return slow == 1;
    }
}

/*
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }

        return n == 1;
    }

    int getSumOfSquares(int num){
        int sum = 0;

        while(num > 0){
            int dig = num % 10;
            sum = sum + dig * dig;
            num = num / 10;
        }
        return sum;
    }
}
*/

