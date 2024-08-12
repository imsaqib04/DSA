import java.util.Arrays;

class Job {
        char id;
        int deadline;
        int profit;


        Job(char id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

class JobSequence {

        static void JobScheduling(Job[] jobs, int n) {

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;

            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i].deadline > maxDeadline) {
                    maxDeadline = jobs[i].deadline;
                }
            }


        int[] slots = new int[maxDeadline];
        Arrays.fill(slots, -1);


        for (Job job : jobs) {
            for (int j = job.deadline - 1; j >= 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = job.id;
                    break;
                }
            }
        }

        // Print the sequence
        System.out.print("Job Sequence: ");
        for (int i = 0; i < maxDeadline; i++) {
            if (slots[i] != -1) {
                System.out.print(slots[i] + " ");
            }
        }
    }

        public static void main(String args[]) {
            Job[] arr = {
                    new Job ( 'a', 2, 100 ),
                    new Job ( 'b', 1, 19 ),
                    new Job ( 'c', 2, 27 ),
                    new Job ( 'd', 1, 25 ),
                    new Job ( 'e', 3, 15 )
            };

            int n = arr.length;

            JobSequence jobSequence = new JobSequence ();
            jobSequence.JobScheduling ( arr, n );

        }
}
