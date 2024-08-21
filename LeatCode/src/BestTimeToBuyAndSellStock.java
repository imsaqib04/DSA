public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minSofar = prices[0];

        for (int i=0;i<prices.length;i++){
            minSofar = Math.min ( minSofar,prices[i]);
            int profit = prices[i]-minSofar;
            maxProfit = Math.max ( maxProfit,profit );
        }
        System.out.println (maxProfit);
        return maxProfit;
    }

    public static void main(String[] args) {

       int  prices [] = {2,3,1,4,7,8};
        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock ();
        bt.maxProfit ( prices );
    }
}