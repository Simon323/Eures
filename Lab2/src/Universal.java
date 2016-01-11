import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

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

    public static Boolean CheckNewRouteIsBetter(ArrayList<Integer> oldRoute, ArrayList<Integer> newRoute, ArrayList<ArrayList<Vertex>> vertexList){

        int oldDistance = Universal.CalculateDistance(oldRoute, vertexList);
        int newDistance = Universal.CalculateDistance(newRoute, vertexList);

        if(oldDistance > newDistance)
            return  true;
        else
            return false;
    }

    public static int CalculateDistance(ArrayList<Integer> route, ArrayList<ArrayList<Vertex>> vertexList){
        int distance = 0;

        for (int i = 0; i < 100; i++){

            Integer currentVertexId = route.get(i);
            ArrayList<Vertex> currentVertex = vertexList.get(currentVertexId);

            if(i + 1 < 100){
                Integer nextVertexId = route.get((i+1));
                Vertex nextVertex = currentVertex.stream().filter(e -> e.idVertex == nextVertexId).collect(Collectors.toList()).get(0);
                distance += nextVertex.edge;
            }else{
                Integer nextVertexId = route.get(0);
                Vertex nextVertex = currentVertex.stream().filter(e -> e.idVertex == nextVertexId).collect(Collectors.toList()).get(0);
                distance += nextVertex.edge;
            }
        }

        return  distance;
    }
}
