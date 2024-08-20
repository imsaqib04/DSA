import java.util.*;

public class KnapsackProblem implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {  // calculate per unit profit (profit&weight ratio)
        Knapsack k1 = (Knapsack) o1;
        Knapsack k2 = (Knapsack) o2;
        Double perUnitProfit_a = (double) (k1.profit/k1.weight);
        Double perUnitProfit_b = (double) (k2.profit/k2.weight);
        return perUnitProfit_b.compareTo(perUnitProfit_a);
    }
    public static class Knapsack{
        double profit;
        double weight;

        Knapsack(double profit, double weight){
            this.profit = profit;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Knapsack k1 = new Knapsack(15,12);
        Knapsack k2 = new Knapsack(34,18);
        Knapsack k3 = new Knapsack(25,8);
       // Knapsack k4 = new Knapsack(35,18);

        ArrayList<Knapsack> knapsackAL = new ArrayList<>();
        knapsackAL.add(k1);
        knapsackAL.add(k2);
        knapsackAL.add(k3);


        int maxBagWeight = 30;

        double maximumProfit = greedyKnapsack(knapsackAL,maxBagWeight);

        System.out.println(maximumProfit);
    }

    private static double greedyKnapsack(ArrayList<Knapsack> knapsackArrayList,double maxBagWeight) {
        Comparator comparator = new KnapsackProblem();
        Collections.sort(knapsackArrayList,comparator);
//        for(Knapsack k:knapsackArrayList){
//            System.out.println(k.weight);
//        }
        double maxProfit = 0;

        while(maxBagWeight>0){
            Knapsack k =knapsackArrayList.get(0);
            if(k.weight<maxBagWeight){
                maxBagWeight=maxBagWeight-k.weight;
                maxProfit = maxProfit+k.profit;
                knapsackArrayList.remove(k);
            }else{
                double profit = maxBagWeight*(k.profit/ k.weight);
                maxProfit = maxProfit+profit;
                maxBagWeight = maxBagWeight -maxBagWeight;
            }
        }
        return maxProfit;
    }

}