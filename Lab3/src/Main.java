import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.corba.se.impl.orbutil.graph.NodeData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        ArrayList<ArrayList<Vertex>> vertexList = Data.getVertexList();

        List<Integer> greedyDistanceList = new ArrayList<>();
        List<Integer> steepDistanceList = new ArrayList<>();

        System.out.println("Greedy");
        long startTimeSteep = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            System.out.println("Wykonano: " + i + "%");
            greedyDistanceList.add(Greedy.Run(vertexList, GRASP.Run()));
        }
        long endTimeSteep = System.currentTimeMillis();
        System.out.println("Executing time: ");
        System.out.print(Universal.CalculateTime(startTimeSteep, endTimeSteep));
        System.out.println("");

        OptionalDouble greedyAv = greedyDistanceList.stream()
                .mapToInt(a -> a)
                .average();
        OptionalInt greedyMin = greedyDistanceList.stream()
                .mapToInt(a -> a)
                .min();
        OptionalInt greedyMax = greedyDistanceList.stream()
                .mapToInt(a -> a)
                .max();
/*
        OptionalDouble steepAv = steepDistanceList.stream()
                .mapToInt(a -> a)
                .average();
        OptionalInt steepMin = steepDistanceList.stream()
                .mapToInt(a -> a)
                .min();
        OptionalInt steepMax = steepDistanceList.stream()
                .mapToInt(a -> a)
                .max();*/


        System.out.println("[Algorytm]   [MIN]   [AV]   [MAX]");
        System.out.println("Greedy   "+greedyAv+"   "+greedyMin+"   "+greedyMax);
       // System.out.println("Steep   "+steepMin+"   "+steepAv+"   "+steepMax);
    }
}
