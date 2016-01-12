import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper;

import java.util.ArrayList;

public class CC {
    public int Run(){
        Data data = new Data();
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        ArrayList<Integer> unusedVertexList = Universal.FillUnusedVertexList();
        ArrayList<ArrayList<Vertex>> vertexList = data.getVertexList();
        int distance = 0;

        int randomVertex = Universal.RandVertex(0, (unusedVertexList.size() - 1));
        resultList.add(randomVertex);
        unusedVertexList.remove(new Integer(randomVertex));

        while (true){
            VertexExtend bestVertex =  FindBestEdge(vertexList, unusedVertexList, resultList);
            //distance += bestVertex.edge;
            unusedVertexList.remove(new Integer(bestVertex.idVertex));
            int indexOfSelectedVertex = resultList.indexOf(bestVertex.selectedVertexNo);
            resultList.add(indexOfSelectedVertex, bestVertex.idVertex);

            if(unusedVertexList.size() < 1){
                break;
            }
        }

        for (Integer i: resultList){
            System.out.print(i + ", ");
        }

        distance = Universal.CalculateDistance(resultList, vertexList);
        System.out.println("Dystans " + distance);

        return distance;
    }

    public VertexExtend FindBestEdge(ArrayList<ArrayList<Vertex>> vertexList, ArrayList<Integer> unusedVertexList, ArrayList<Integer> resultList){

        boolean isInitialize = false;
        Vertex bestVertex = new Vertex(0,0);
        int selectedVertexNo = 0;

        for (Integer vertexNo : resultList){
            ArrayList<Vertex> currentVertex = vertexList.get(vertexNo);

            for (Integer unusedVertexNo : unusedVertexList){

                for (Vertex x : currentVertex){

                    if(unusedVertexNo == x.idVertex){
                        if(isInitialize == false){
                            bestVertex = x;
                            selectedVertexNo = vertexNo;
                            isInitialize = true;
                            break;
                        }

                        if(x.edge < bestVertex.edge){
                            bestVertex = x;
                            selectedVertexNo = vertexNo;
                            break;
                        }
                    }
                }

            }
        }

        return  new VertexExtend(selectedVertexNo, bestVertex.idVertex, bestVertex.edge);
    }
}
