
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caseyubvm
 */
public class SimpleGraph implements Serializable{
    private int[][] adjacencyMatrix;
    private int count;
    private boolean counted = false;
    
    SimpleGraph(int[][] adjacencyMatrix){
        this.adjacencyMatrix = adjacencyMatrix;
    }

    /**
     * @return the adjacencyMatrix
     */
    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    /**
     * @param adjacencyMatrix the adjacencyMatrix to set
     */
    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }
    
    public int getCount(){
        if(!counted){
            int counter = 0;
            for(int i = 0; i < adjacencyMatrix.length; i++){
                for(int j = 0; j < adjacencyMatrix[i].length; j++){
                    counter++;
                }
            }
            count = counter;
            counted = true;
        }
        return count;
    }
    
    public boolean getCounted(){
        return this.counted;
    }
    
    public void print(){
        for(int i = 0; i < adjacencyMatrix.length; i++){
            for(int j = 0; j < adjacencyMatrix[i].length; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public void printSideBySide(SimpleGraph otherGraph){
        if(this.getCount() != otherGraph.getCount()){
            System.out.println("The two graphs do not have the same number of vertices.");
        }
        else{
            for(int i = 0; i < adjacencyMatrix.length; i++){
                for(int j = 0; j < adjacencyMatrix[i].length; j++){
                    System.out.print(adjacencyMatrix[i][j] + " ");
                }
                System.out.print("  ");
                for(int x = 0; x < adjacencyMatrix[i].length; x++){
                    System.out.print(otherGraph.adjacencyMatrix[i][x] + " ");
                }
                System.out.println();
            }
        }
    }
}
