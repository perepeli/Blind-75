package problems;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max){
                max = candies[i];
            }
        }

        ArrayList<Boolean> greatestNumberCheck = new ArrayList<Boolean>(candies.length);

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                greatestNumberCheck.add(true);
            } else {
                greatestNumberCheck.add(false);
            }
        }
        return greatestNumberCheck;
    }
}
