public class TrionicArray_I {

        public boolean isTrionic(int[] nums) {
            int n = nums.length;
            if (n < 4) return false;

            int i = 0;

            // 1️⃣ increase
            while (i + 1 < n && nums[i] < nums[i + 1]) i++;
            if (i == 0) return false;

            // 2️⃣ decrease
            int d = i;
            while (i + 1 < n && nums[i] > nums[i + 1]) i++;
            if (i == d) return false;

            // 3️⃣ increase again
            int u = i;
            while (i + 1 < n && nums[i] < nums[i + 1]) i++;
            if (i == u) return false;

            return i == n - 1;
        }
    }
