package at.challenges.Bat;

public class CanBalance {

    public static boolean canBalance( int[] nums){
        int pos = 0;
        int ergLeft = 0;
        int ergRight = 0;

        for (int i = 0; i < nums.length; i++){
          if (i < 4){
                ergRight += nums[i];
            } else {
              ergLeft += nums[i];
          }
            if (ergLeft == ergRight){
                return true;
            } else {
                ergLeft = 0;
                ergRight = 0;
            }
        }
        return false;
    }
}
