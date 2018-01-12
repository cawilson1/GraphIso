
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
public class GraphIsoMethods {

    public static MatrixPoint chooseArbitraryFirstIndex(SimpleGraph graph) throws CannotBeIsomorphicException {

        int[][] adjMat = graph.getAdjacencyMatrix();

        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {

                if (adjMat[i][j] != 0) {
                    int[] temp = {i, j};
                    return new MatrixPoint(graph, i,j,adjMat[i][j]);

                }
            }
        }
        return new MatrixPoint(false);
    }
    
    /**
     * works for both rows and columns
     * @param array
     * @return 
     */
    public static HashMap<Integer, MutableInt> constructOccurenceCounter(int[] array){
        HashMap<Integer, MutableInt> toReturn = new HashMap<Integer, MutableInt>();
        
        for(int i = 0; i < array.length; i++){
            try{
                toReturn.get(array[i]).increment();
            }
            catch(NullPointerException ex){
                toReturn.put(array[i], new MutableInt(1));
            }
        }
        
        return toReturn;
    }
    
    public static void printOccurenceCounter(HashMap<Integer, MutableInt> hash){
        for(Integer key: hash.keySet()){
            System.out.println("key: " + key + " value: " + hash.get(key).getValue());
        }
    }
    
    public static boolean isRowAndColCountEqual(HashMap<Integer, MutableInt> graph1Row, HashMap<Integer, MutableInt> graph1Col, 
                                                HashMap<Integer, MutableInt> graph2Row, HashMap<Integer, MutableInt> graph2Col){
        
        boolean possible = true;
        System.out.println();
       // System.out.println(graph1Row.keySet() + " and " + graph2Row.keySet());
        
        for(Integer rowKey: graph1Row.keySet()){
            System.out.print( "here ");
            if(!possible)
                break;
            if(graph1Row.get(rowKey).getValue() != graph2Row.get(rowKey).getValue()){
                System.out.print(possible);//System.out.print(rowKey);
                possible = false;
            }
        }
        for(Integer colKey: graph1Col.keySet()){
            if(!possible)
                break;
            if((graph1Col.get(colKey).getValue() != graph2Col.get(colKey).getValue())){
               System.out.print(possible);// System.out.print(colKey);
                possible = false;
            }
        }
        
        System.out.print(possible);
        return possible;
    }
}
