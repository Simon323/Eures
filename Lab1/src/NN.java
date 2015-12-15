import java.util.ArrayList;

public class NN {
    public int Run(){
        Data data = new Data();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        ArrayList<ArrayList<Vertex>> vertexList = data.getVertexList();
        ArrayList<Integer> unusedVertexList = Universal.FillUnusedVertexList();
        int distance = 0;

        int randomVertex = Universal.RandVertex(0, (unusedVertexList.size() - 1));
        resultList.add(randomVertex);

        unusedVertexList.remove(new Integer(randomVertex));
        Vertex bestVertex = FindBestEdge(vertexList.get(randomVertex), unusedVertexList);
        distance += bestVertex.edge;
        while (true){
            resultList.add(bestVertex.idVertex);
            unusedVertexList.remove(new Integer(bestVertex.idVertex));
            if(unusedVertexList.size() < 1){
                break;
            }
            bestVertex = FindBestEdge(vertexList.get(bestVertex.idVertex), unusedVertexList);
            distance += bestVertex.edge;
        }

        for (Integer i: resultList){
            System.out.println(i);
        }
        System.out.println("Dystans " + distance);
        return distance;
    }

    public Vertex FindBestEdge(ArrayList<Vertex> edgeVertex, ArrayList<Integer> unusedVertexList){

        boolean isBestEdgeInitialize = false;
        Vertex bestEdge = new Vertex(0,0);

        for (Integer unusedVertex : unusedVertexList){
            Vertex currentVertex = new Vertex(0,0);

            for (Vertex iter : edgeVertex){
                if(iter.idVertex == unusedVertex){
                    currentVertex = iter;
                }
            }

            if(!isBestEdgeInitialize){
                bestEdge = currentVertex;
                isBestEdgeInitialize = true;
            }

            if (bestEdge.edge > currentVertex.edge){
                bestEdge = currentVertex;
            }
        }

        return bestEdge;
    }
}
