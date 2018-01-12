/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caseyubvm
 */
public class MutableInt {
    private int value;
    
    public MutableInt(int value){
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    public void increment(){
        this.value++;
    }
    
    public void decrement(){
        this.value--;
    }
}
