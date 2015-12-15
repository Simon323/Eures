import java.util.ArrayList;
import java.util.Random;

public final class Universal {

    public static int RandVertex(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public static ArrayList<Integer> FillUnusedVertexList(){

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++){
            result.add(i);
        }

        return  result;
    }
}
