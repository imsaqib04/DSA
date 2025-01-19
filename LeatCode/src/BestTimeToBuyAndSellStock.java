public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

//        int maxPro = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                if (prices[j] > prices[i]) {
//                    maxPro = Math.max(prices[j] - prices[i], maxPro);
//                }
//            }
//        }
//        System.out.println (maxPro);
//        return maxPro;

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

//       int  prices [] = {2,3,1,4,7,8};
        int  prices [] = {3,3,5,0,0,3,1,4};

        BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock ();
        bt.maxProfit ( prices );
    }
}