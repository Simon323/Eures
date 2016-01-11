import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    public static void main(String args[]){
        List<Integer> graspList = new ArrayList<>();
        List<Integer> nnList = new ArrayList<>();
        List<Integer> ccList = new ArrayList<>();

        GRASP grasp = new GRASP();
        NN nn = new NN();
        CC cc = new CC();
        //grasp.Run();
        //nn.Run();
        cc.Run();

        /*System.out.println("GRASP");
        for (int i = 0; i < 100; i++) {
            graspList.add(grasp.Run());
        }
        System.out.println("NN");
        for (int i = 0; i < 100; i++) {
            nnList.add(nn.Run());
        }
        System.out.println("CC");
        for (int i = 0; i < 100; i++) {
            ccList.add(cc.Run());
        }

        OptionalDouble graspAv = graspList.stream()
                .mapToInt(a -> a)
                .average();
        OptionalInt graspMin = graspList.stream()
                .mapToInt(a -> a)
                .min();
        OptionalInt graspMax = graspList.stream()
                .mapToInt(a -> a)
                .max();

        OptionalDouble nnAv = nnList.stream()
                .mapToInt(a -> a)
                .average();
        OptionalInt nnMin = nnList.stream()
                .mapToInt(a -> a)
                .min();
        OptionalInt nnMax = nnList.stream()
                .mapToInt(a -> a)
                .max();

        OptionalDouble ccAv = ccList.stream()
                .mapToInt(a -> a)
                .average();
        OptionalInt ccMin = ccList.stream()
                .mapToInt(a -> a)
                .min();
        OptionalInt ccMax = ccList.stream()
                .mapToInt(a -> a)
                .max();

        System.out.println("[Algorytm]   [MIN]   [AV]   [MAX]");
        System.out.println("NN   "+nnMin+"   "+nnAv+"   "+nnMax);
        System.out.println("GRASP   "+graspMin+"   "+graspAv+"   "+graspMax);
        System.out.println("CC   "+ccMin+"   "+ccAv+"   "+ccMax);*/
    }
}
