public class CheckIfItIsAStraightLine {
        public boolean checkStraightLine(int[][] coordinates) {

            int n = coordinates.length;

            for(int i =0;i<n;i++){
                for(int j=i+1;j<n;j++){

                    int x1= coordinates[i][0];
                    int y1= coordinates[i][1];
                    int x2= coordinates[j][0];
                    int y2= coordinates[j][1];

                    boolean ok = true;

                    for(int k = 0;k<n;k++){
                        int x3 = coordinates[k][0];
                        int y3 = coordinates[k][1];

                        if((x2-x1)*(y3-y1) != (x3-x1)*(y2-y1)){
                            ok = false;
                            break;
                        }

                    }
                    if(ok){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    // optimized O(n)
//class Solution {
//    public boolean checkStraightLine(int[][] coordinates) {
//
//        int n = coordinates.length;
//
//        int x1 = coordinates[0][0];
//        int y1 = coordinates[0][1];
//        int x2 = coordinates[1][0];
//        int y2 = coordinates[1][1];
//
//        for (int i = 2; i < n; i++) {
//            int x3 = coordinates[i][0];
//            int y3 = coordinates[i][1];
//
//            if ((x2 - x1) * (y3 - y1) != (y2 - y1) * (x3 - x1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//}