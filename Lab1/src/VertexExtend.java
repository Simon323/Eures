public class VertexExtend extends Vertex {
    public int selectedVertexNo;

    public VertexExtend(int selectedVertexNo, int idVertex, int edge){
        super(idVertex, edge);
        this.selectedVertexNo = selectedVertexNo;
    }
}
