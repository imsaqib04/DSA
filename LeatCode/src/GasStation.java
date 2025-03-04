class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;    // Tracks the current fuel in the car during the journey
        int total = 0;   // Tracks the net gain or loss of fuel for the whole journey
        int index = 0;   // Stores the starting gas station index

        for (int i = 0; i < gas.length; i++) {
            int consume = gas[i] - cost[i];  // Net fuel gained/lost at this station
            tank += consume;                // Add this station's net fuel to the tank
            total += consume;               // Add this station's net fuel to the total journey

            // If tank goes negative, the journey from the current starting station fails
            if (tank < 0) {
                tank = 0;        // Reset the tank
                index = i + 1;   // Try starting from the next station
            }
        }

        // If total fuel gain is negative, it's impossible to complete the circuit
        return total < 0 ? -1 : index;
    }
}
