class StringToInteger {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;
        int sign = 1; // 1 for positive (default), -1 for negative
        long result = 0; // Use long to detect overflow

        // 1. Whitespace: Ignore any leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Signedness: Determine the sign
        if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (i < n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        }

        // 3. Conversion: Read digits until a non-digit or end of string
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // Convert char '0'-'9' to int 0-9

            // Build the number
            result = result * 10 + digit;

            // 4. Rounding (Clamping): Check for overflow/underflow on each step
            if (sign == 1 && result > Integer.MAX_VALUE) {
                // Positive overflow
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && (-result) < Integer.MIN_VALUE) {
                // Negative overflow
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // Return the integer with the correct sign
        // We cast the final 'long' result back to 'int'
        return (int)(result * sign);
    }
}