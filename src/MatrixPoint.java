/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caseyubvm
 */
public class MatrixPoint {
    
    private SimpleGraph graph;
    private int i;
    private int j;
    private int value;
    private int[] valuesOnSameRow;
    private int[] valuesOnSameColumn;
    
    private MatrixPoint(){
        
    }
    
    public MatrixPoint(SimpleGraph graph, int i, int j, int value){
        this.graph = graph;
        this.i = i;
        this.j = j;
        this.value = value;
        setValuesOnSameRow();
        setValuesOnSameColumn();
    }
    
    public MatrixPoint(boolean valid) throws CannotBeIsomorphicException{
        throw new CannotBeIsomorphicException("There is no initial value that does not equal zero.");
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @return the j
     */
    public int getJ() {
        return j;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @return the graph
     */
    public SimpleGraph getGraph() {
        return graph;
    }

    private void setValuesOnSameRow(){
        int[] values = new int[graph.getAdjacencyMatrix().length];
        for(int x = 0; x < graph.getAdjacencyMatrix().length; x++){
            values[x] = graph.getAdjacencyMatrix()[i][x];
        }
        valuesOnSameRow = values;
    }
    
    /**
     * @return the valuesOnSameRow
     */
    public int[] getValuesOnSameRow() {
        return valuesOnSameRow;
    }
    
    private void setValuesOnSameColumn(){
        int[] values = new int[graph.getAdjacencyMatrix()[i].length];
        for(int x = 0; x < graph.getAdjacencyMatrix()[i].length; x++){
            values[x] = graph.getAdjacencyMatrix()[x][j];
        }
        valuesOnSameColumn = values;
    }

    /**
     * @return the valuesOnSameColumn
     */
    public int[] getValuesOnSameColumn() {
        return valuesOnSameColumn;
    }
    
    public void printValues(){
        System.out.println("The position is i: " + getI() + ", j: " + getJ() + " and value " + getValue());
    }
    
    /**
     * Prints the row including the current MatrixPoint
     */
    public void printSameRowInclusive(){
        for(int x = 0; x < valuesOnSameRow.length; x++){
            System.out.print(valuesOnSameRow[x] + " ");
        }
        System.out.println();
    }
    
    /**
     * Prints the column including the current MatrixPoint
     */
    public void printSameColumnInclusive(){
        for(int x = 0; x < valuesOnSameColumn.length; x++){
            System.out.print(valuesOnSameColumn[x] + " ");
        }
        System.out.println();
    }
}
