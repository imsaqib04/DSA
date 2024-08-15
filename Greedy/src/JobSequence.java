import java.util.ArrayList;
import java.util.Collections;

public class JobSequence {

    static class Job implements Comparable<Job>{

        String name;
        int deadline;
        int profit;

        @Override
        public int compareTo(Job otherJob) {
            return otherJob.profit - this.profit;
        }

        public Job(String name, int deadline, int profit) {
            this.name = name;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public void findJobSequence(ArrayList<Job> jobs){

        Collections.sort(jobs);

        int totalJobs= jobs.size();
        boolean[] slots = new boolean[totalJobs];
        int[] sequence = new int[totalJobs];

        for (int i = 0; i < totalJobs; i++) {
            for (int j = jobs.get(i).deadline - 1; j >= 0; j--) {
                if (!slots[j]) {
                    sequence[j] = i;
                    slots[j] = true;
                    break;
                }
            }
        }
        System.out.print("Jobs: ");
        int totalProfit=0;
        for (int i = 0; i < jobs.size(); i++) {
            if (slots[i]){
                System.out.print(jobs.get(sequence[i]).name + " ");
                totalProfit += jobs.get(sequence[i]).profit;
            }
        }
        System.out.println(", Total Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job a = new Job("A", 2, 102);
        Job b = new Job("B", 1, 94);
        Job c = new Job("C", 2, 220);
        Job d = new Job("D", 3, 50);
        Job e = new Job("E", 3, 15);

        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(a);
        jobs.add(b);
        jobs.add(c);
        jobs.add(d);
        jobs.add(e);

        JobSequence jobSequencing = new JobSequence ();
        jobSequencing.findJobSequence(jobs);
    }
}