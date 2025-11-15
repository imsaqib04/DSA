class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        // Smallest possible eating speed (Koko must eat at least 1 banana per hour)
        int minSpeed = 1;

        // Largest possible speed = size of the biggest pile
        // (because eating faster than the max pile doesn't change anything)
        int maxSpeed = 0;
        for (int p : piles) {
            maxSpeed = Math.max(maxSpeed, p);
        }

        // Binary search on the answer (k = eating speed)
        // We try to find the minimum value of k for which she can finish on time
        while (minSpeed < maxSpeed) {

            // Mid speed (current guess)
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;

            // If Koko CAN finish all bananas at speed 'mid'
            // then try to reduce the eating speed (go left)
            if (canFinish(piles, h, mid)) {
                maxSpeed = mid;
            }
            // If Koko CANNOT finish at speed 'mid'
            // she needs to eat faster (go right)
            else {
                minSpeed = mid + 1;
            }
        }

        // When minSpeed == maxSpeed → we found the minimum valid eating speed
        return minSpeed;
    }

    // Helper method: checks if Koko can finish all piles within 'h' hours at speed 'k'
    private Boolean canFinish(int[] piles, int h, int k) {

        int hours = 0;

        for (int p : piles) {

            // Time needed for one pile if she eats 'k' bananas/hour
            // Using ceil(p / k) but implemented as: (p + k - 1) / k
            // Example: p=7, k=3 → ceil(7/3) = 3 hours
            hours = hours + (p + k - 1) / k;
        }

        // If total hours required are within allowed time 'h' → return true
        return hours <= h;
    }
}
