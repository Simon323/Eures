import com.sun.corba.se.impl.orbutil.graph.Graph;
import com.sun.corba.se.impl.orbutil.graph.Node;
import com.sun.corba.se.impl.orbutil.graph.NodeData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]){
        ArrayList<ArrayList<Vertex>> vertexList = Data.getVertexList();
        ArrayList<Integer> solution = GRASP.Run();
        Greedy.Run(vertexList, solution);
        //ArrayList<Vertex> x = list.get(0);
        //Vertex zmienna = x.stream().filter(e -> e.idVertex == 3).collect(Collectors.toList()).get(0);
    }
}
