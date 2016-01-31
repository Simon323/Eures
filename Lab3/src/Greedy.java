import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Greedy {

    public static int Run(ArrayList<ArrayList<Vertex>> vertexList, ArrayList<Integer> solution){
        int distance = 0;
        solution = LocalSearchGreedy(vertexList, solution);
        long startTimeSteep = System.currentTimeMillis();
        while(true){
            long currentTime = System.currentTimeMillis();
            if(currentTime - startTimeSteep > Universal.time)
                break;

            ArrayList<Integer> temp = Perturbance(solution);
            int currentSolutionDistance = Universal.CalculateDistance(solution, vertexList);
            int newDistance = Universal.CalculateDistance(temp, vertexList);

            if(newDistance < currentSolutionDistance)
                solution = (ArrayList<Integer>)temp.clone();
        }

        long endTimeSteep = System.currentTimeMillis();

        for (Integer i: solution){
            System.out.print(i + ", ");
        }
        return  distance;
    }

    public static ArrayList<Integer> LocalSearchGreedy(ArrayList<ArrayList<Vertex>> vertexList, ArrayList<Integer> solution){
        int distance = Universal.CalculateDistance(solution, vertexList);
        ArrayList<Integer> testSolution = (ArrayList<Integer>)solution.clone();

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

        for (Integer i: solution){
            System.out.print(i + ", ");
        }
        System.out.println("Dystans " + distance);

        return  testSolution;
    }

    public static ArrayList<Integer> Perturbance(ArrayList<Integer> solution){

        int randomVertexOne = Universal.RandVertex(0, 99);
        int randomVertexTwo = Universal.RandVertex(0, randomVertexOne == 0 ? 0 : randomVertexOne - 1);

        int startReversePlace = solution.indexOf(randomVertexOne) + 1;
        int stopReversePlace = solution.indexOf(randomVertexTwo) - 1;

        if(startReversePlace > solution.size())
            startReversePlace = solution.size() - 1;

        if(stopReversePlace < 0)
            stopReversePlace = 0;

        int vertexOneValue = solution.get(randomVertexOne);
        int vertexTwoValue = solution.get(randomVertexTwo);
        solution.set(randomVertexOne, vertexTwoValue);
        solution.set(randomVertexTwo, vertexOneValue);

        Collections.reverse(solution.subList(randomVertexTwo, randomVertexOne + 1));

        return solution;
    }
}
