import java.util.ArrayList;

public class GRASP {
    public void Run(){
        Data data = new Data();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        ArrayList<Integer> unusedVertexList = Universal.FillUnusedVertexList();
        ArrayList<ArrayList<Vertex>> vertexList = data.getVertexList();

        int randomVertex = Universal.RandVertex(0, (unusedVertexList.size() - 1));
        resultList.add(randomVertex);

        unusedVertexList.remove(new Integer(randomVertex));
        Vertex bestVertex = ChoiceRandomFromBestEdge(vertexList.get(randomVertex), unusedVertexList);

        while (true){
            resultList.add(bestVertex.idVertex);
            unusedVertexList.remove(new Integer(bestVertex.idVertex));
            if(unusedVertexList.size() < 1){
                break;
            }
            bestVertex = ChoiceRandomFromBestEdge(vertexList.get(bestVertex.idVertex), unusedVertexList);
        }

        for (Integer i: resultList){
            System.out.println(i);
        }
    }

    public Vertex ChoiceRandomFromBestEdge(ArrayList<Vertex> edgeVertex, ArrayList<Integer> unusedVertexList){

        ArrayList<Vertex> bestEdgeList = new ArrayList<Vertex>();

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

        int selectedVertex = Universal.RandVertex(0, (bestEdgeList.size() - 1));

        return bestEdgeList.get(selectedVertex);
    }
}
