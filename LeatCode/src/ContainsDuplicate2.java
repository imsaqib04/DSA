import java.util.HashMap;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<> ();

        for (int i = 0; i < n; i++) {

            if (map.containsKey ( nums[i] ) && i - map.get ( nums[i] ) <= k) {
                return true;
            }
            map.put ( nums[i], i );
        }
        return false;
    }
}


    // for(int i = 0; i < n; i++){
    //     for(int j = 0; j < n; j++){
    //         if(i != j && nums[i] == nums[j] && Math.abs(i-j)<=k){
    //             return true;
    //         }
    //     }
    // }
    // return false;
