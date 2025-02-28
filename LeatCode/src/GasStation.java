public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;
        int total = 0;
        int index = 0;

        for (int i = 0; i < gas.length; i++) {
            int consume = gas[i] - cost[i];
            tank += consume;
            total += consume;

            if (tank < 0) {
                // Resetting the route, starting from the next station
                tank = 0;
                index = i + 1;  // The new start station
            }
        }

        return total < 0 ? -1 : index;
    }

    class Solution {
    }
}