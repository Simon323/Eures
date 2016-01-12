import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;

public class Steep {
    public static int Run(ArrayList<ArrayList<Vertex>> vertexList, ArrayList<Integer> solution){
        int distance = Universal.CalculateDistance(solution, vertexList);
        ArrayList<ArrayList<Integer>> testSolutionList;
        //System.out.println("Start distance " + distance);

        long startTime=System.currentTimeMillis();
        while (true){
            testSolutionList = GeneratePotentialBetterSolution(solution);
            ArrayList<Integer> testSolution = FindBestRoute(testSolutionList, vertexList);
            Boolean isBetter = Universal.CheckNewRouteIsBetter(solution, testSolution, vertexList);
            if(isBetter){
                solution = (ArrayList<Integer>)testSolution.clone();
            }else{
                break;
            }
        }

        //long endTime=System.currentTimeMillis();
        //System.out.println("Executing time: ");
        //System.out.print(Universal.CalculateTime(startTime, endTime));
        distance = Universal.CalculateDistance(solution,vertexList);

        for (Integer i: solution){
            System.out.print(i + ", ");
        }
        System.out.println("Dystans " + distance);

        return  distance;
    }

    public static ArrayList<ArrayList<Integer>> GeneratePotentialBetterSolution(ArrayList<Integer> solution){

        ArrayList<ArrayList<Integer>> testSolutionList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> testSolution = (ArrayList<Integer>)solution.clone();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < i; j++) {
                int vertexOne = solution.get(i);
                int vertexTwo = solution.get(j);
                testSolution.set(i, vertexTwo);
                testSolution.set(j, vertexOne);
                ArrayList<Integer> temp = (ArrayList<Integer>)testSolution.clone();
                testSolutionList.add(temp);
                testSolution = (ArrayList<Integer>)solution.clone();
            }
        }

        return  testSolutionList;
    }

    public static ArrayList<Integer> FindBestRoute(ArrayList<ArrayList<Integer>> testSolutionList, ArrayList<ArrayList<Vertex>> vertexList){

        int bestDistance = Universal.CalculateDistance(testSolutionList.get(0), vertexList);
        ArrayList<Integer> bestRoute = (ArrayList<Integer>)testSolutionList.get(0).clone();

        for (ArrayList<Integer> testSolution : testSolutionList){
            int newDistance = Universal.CalculateDistance(testSolution, vertexList);

            if(newDistance < bestDistance){
                bestDistance = newDistance;
                bestRoute = (ArrayList<Integer>)testSolution.clone();
            }
        }

        return  bestRoute;
    }
}
