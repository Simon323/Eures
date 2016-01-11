import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Greedy {

    public static void Run(ArrayList<ArrayList<Vertex>> vertexList, ArrayList<Integer> solution){
        int distance = Universal.CalculateDistance(solution, vertexList);
        ArrayList<Integer> testSolution = (ArrayList<Integer>)solution.clone();
        System.out.println("Start distance " + distance);

        for (int i = 0; i < 100; i++){
            for(int j = 0; j < i; j++){
                int vertexOne = solution.get(i);
                int vertexTwo = solution.get(j);
                testSolution.set(i, vertexTwo);
                testSolution.set(j, vertexOne);
                Boolean isBetter = Universal.CheckNewRouteIsBetter(solution, testSolution, vertexList);

                if(isBetter){
                    solution = (ArrayList<Integer>)testSolution.clone();
                    i = 0;
                    break;
                }else{
                    testSolution = (ArrayList<Integer>)solution.clone();
                }
            }
        }

        distance = Universal.CalculateDistance(solution,vertexList);
        System.out.println("optimum distance " + distance);
    //    return  distance;
    }
}
