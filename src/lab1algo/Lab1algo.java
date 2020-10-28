/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1algo;

/**
 *
 * @author Admin
 */
public class Lab1algo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int testArr[] = {3, 6, 1, 8, 12, 4, 7};
        
        HeapSort sortObject = new HeapSort();
        
        sortObject.sort(testArr);
        
        for (int i = 0; i<testArr.length; i++){
            
            System.out.print(testArr[i] + " ");
            
        }
        
        
    }
    
}
