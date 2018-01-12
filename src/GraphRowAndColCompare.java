
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caseyubvm
 */
public class GraphRowAndColCompare{
    SimpleGraph graph1;
    SimpleGraph graph2;
    MatrixPoint point;
    HashMap RowOccurenceCounterG1;
    HashMap ColOccurenceCounterG1;
   
    
    private GraphRowAndColCompare(){  
    }
    
    public GraphRowAndColCompare(SimpleGraph graph1, SimpleGraph graph2) throws CannotBeIsomorphicException{
        
        this.graph1 = graph1;
        this.graph2 = graph2;
        this.point = GraphIsoMethods.chooseArbitraryFirstIndex(graph1);
        this.RowOccurenceCounterG1 = GraphIsoMethods.constructOccurenceCounter(point.getValuesOnSameRow());
        this.ColOccurenceCounterG1 = GraphIsoMethods.constructOccurenceCounter(point.getValuesOnSameColumn());
    }
    
    public MatrixPoint findSimilarPoint(){
        
        boolean exitLoop = false;
        int[][] matrix = graph2.getAdjacencyMatrix();
        
        for(int i = 0; i < matrix.length && !exitLoop; i++){
            for(int j = 0; j < matrix[i].length && !exitLoop; j++){
                MatrixPoint tempPoint = new MatrixPoint(graph2, i, j, matrix[i][j]);
                
                if(GraphIsoMethods.isRowAndColCountEqual(this.RowOccurenceCounterG1, this.ColOccurenceCounterG1, 
                        GraphIsoMethods.constructOccurenceCounter(tempPoint.getValuesOnSameRow()), 
                        GraphIsoMethods.constructOccurenceCounter(tempPoint.getValuesOnSameColumn()))){
                        return tempPoint;
                }
            }
        }
        return new MatrixPoint(graph2,3,3,3);
    }
    
    public void printSimilarPointValues(){
        System.out.println("not implemented yet");
    }
    
}
