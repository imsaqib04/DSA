public class TaskScheduler{
        public int leastInterval(char[] tasks, int n) {
            int[] freq = new int[26];

            // Count frequency of tasks
            for (char c : tasks) {
                freq[c - 'A']++;
            }

            // Find maximum frequency
            int maxFreq = 0;
            for (int f : freq) {
                maxFreq = Math.max(maxFreq, f);
            }

            // Count how many tasks have max frequency
            int maxCount = 0;
            for (int f : freq) {
                if (f == maxFreq) {
                    maxCount++;
                }
            }

            // Calculate minimum intervals needed
            int intervals = (maxFreq - 1) * (n + 1) + maxCount;

            // Return the maximum of total tasks or calculated intervals
            return Math.max(tasks.length, intervals);
        }
    }
