public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1; // Increment the current digit
                return digits;  // Return immediately if no carry is needed
            } else {
                digits[i] = 0; // Set the current digit to 0 if it's 9
            }
        }

        // If all digits were 9, create a new array with an extra digit
        int[] arr = new int[digits.length + 1];
        arr[0] = 1; // Set the first digit to 1 (e.g., 999 -> 1000)
        return arr;
    }
}