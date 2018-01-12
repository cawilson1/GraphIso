/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caseyubvm
 */
public class TestMain {
    
    public static void main (String[] args) throws CannotBeIsomorphicException{
        
        int[][] temp = {{0,1,0,1},{1,0,1,0},{0,1,0,1},{1,0,1,0}};
        SimpleGraph graphG = new SimpleGraph(temp);
        int[][] temp2 = {{0,1,1,0},{1,0,0,1},{1,0,0,1},{0,1,1,0}};
        SimpleGraph graphH = new SimpleGraph(temp2);
        int[][] temp3 = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        SimpleGraph graphI = new SimpleGraph(temp3);
        System.out.println(graphH.getCount());
        graphG.printSideBySide(graphH);
        
        MatrixPoint point = GraphIsoMethods.chooseArbitraryFirstIndex(graphG);
        point.printValues();
        point.printSameRowInclusive();
        point.printSameColumnInclusive();
        
        GraphIsoMethods.printOccurenceCounter(GraphIsoMethods.constructOccurenceCounter(point.getValuesOnSameRow()));
        GraphIsoMethods.printOccurenceCounter(GraphIsoMethods.constructOccurenceCounter(point.getValuesOnSameColumn()));
        
        System.out.println("-----------------------------------------------------------------------");
        
        GraphRowAndColCompare compare = new GraphRowAndColCompare(graphG, graphH);
        MatrixPoint similarPoint = compare.findSimilarPoint();
        similarPoint.printValues();
    }
    
}
