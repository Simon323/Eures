import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

/**
 * Created by Szymon-Acer on 14.12.2015.
 */
public class GRASP {
    public void Run(){
        Data data = new Data();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        ArrayList<Integer> unusedVertexList = FillUnusedVertexList();
        ArrayList<ArrayList<Vertex>> vertexList = data.getVertexList();

        int randomVertex = RandVertex(0, (unusedVertexList.size() - 1));
        resultList.add(randomVertex);

        unusedVertexList.remove(new Integer(randomVertex));
        Vertex bestVertex = FindBestEdge(vertexList.get(randomVertex), unusedVertexList);

        while (true){
            resultList.add(bestVertex.idVertex);
            unusedVertexList.remove(new Integer(bestVertex.idVertex));
            if(unusedVertexList.size() < 1){
                break;
            }
            bestVertex = FindBestEdge(vertexList.get(bestVertex.idVertex), unusedVertexList);
        }

        for (Integer a : resultList){
            System.out.println(a);
        }
/*        System.out.println();
        System.out.println("Wybrany node");
        System.out.println("id: "+ ind.idVertex + " edge: " + ind.edge);*/

    }

    public int RandVertex(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public Vertex FindBestEdge(ArrayList<Vertex> edgeVertex, ArrayList<Integer> unusedVertexList){

        ArrayList<Vertex> bestEdgeList = new ArrayList<Vertex>();
        //System.out.println("Wierzcholerk startowy: " + start);

        for (Integer unusedVertex : unusedVertexList){
            Vertex currentVertex = new Vertex(0,0);

            for (Vertex iter : edgeVertex){
                if(iter.idVertex == unusedVertex){
                    currentVertex = iter;
                }
            }

            if(bestEdgeList.size() < 10){
                bestEdgeList.add(currentVertex);
            }

            if (bestEdgeList.size() >= 10){
                Vertex max = bestEdgeList.get(0);
                for (int j = 1; j < bestEdgeList.size(); j++){
                    if(bestEdgeList.get(j).edge > max.edge){
                        max = bestEdgeList.get(j);
                    }
                }

                if(max.edge > currentVertex.edge){
                    bestEdgeList.remove(max);
                    bestEdgeList.add(currentVertex);
                }
            }
        }

/*        System.out.println("Najlepsze opcje");
        for (int k = 0; k < bestEdgeList.size(); k++){
            System.out.print("wierzcholerk: " + bestEdgeList.get(k).idVertex);
            System.out.print("krawedz: " + bestEdgeList.get(k).edge);
            System.out.println();
        }*/

        int selectedVertex = RandVertex(0, (bestEdgeList.size() - 1));

        return bestEdgeList.get(selectedVertex);
    }

    public ArrayList<Integer> FillUnusedVertexList(){

        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++){
            result.add(i);
        }

        return  result;
    }
}
