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

public class HeapSort {
    
    
    //takes array and number of elements in the array
    public void buildMaxHeap(int arr[], int numberOfElements) 
    { 
        // When we build a max heap we need to find the middle starting point. 
        // We do this by taking the floor of n/2 where n is number of elements. 
        // This gives us the ndex of last non-leaf node. In java, integer division 
        // rounds down so we don't have to take the floor of numberOfElements/2 since 
        // java already does it. 
        // Also, we subtract one because the index for arrays starts at 0. 
        int lastNonLeafNode = (numberOfElements/ 2) - 1; 
  
        
        // Here we start at the index that is the middle point of the array. 
        // At each iteration of i, we call maxHeapify. 
        // This looks at a node cluster(parent and two children) and places
        // the largest of the 3 nodes in the parent position. If a swap occurs, 
        // the parent node that was swapped then 
        // has maxHeapify called on it. This occurs all the way down the tree. 
        for (int i = lastNonLeafNode; i >= 0; i--) { 
            maxHeapify(arr, numberOfElements, i); 
        } 
    } 
    
    
    //max heapify takes an array, 
    public void maxHeapify(int arr[], int sizeOfHeap, int rootIndex) 
    { 
        // largest is going to be set equal to our root index which is our 
        // parent node essentially
        int largest = rootIndex; 
        
        // formula to get left child index = 2*i + 1 where i = root index
        int leftChildIndex = 2*rootIndex + 1; 
        
        // formula to get right child index = 2*i + 2  where i = root index
        int rightChildIndex = 2*rootIndex + 2; 
  
        // first we check to make sure the left child index is even in our 
        // heap by making sure its less than our heap size,
        // if it is then we check to see if the left child is larger than 
        // our root. If it is we set largest equal to the left child index. 
        if (leftChildIndex <= sizeOfHeap && arr[leftChildIndex] > arr[largest]) 
            largest = leftChildIndex; 
  
        // Next we do the same thing for the right child. 
        // We check to make sure the right child index is even in our heap by making sure 
        // its less than our heap size, if it is then we check to see if the right child is 
        // larger than our what our largest variable is set to. If it is we set largest equal
        // to the right child index.  
        if (rightChildIndex <= sizeOfHeap && arr[rightChildIndex] > arr[largest]) 
            largest = rightChildIndex; 
  
        // Here we check to see if largest is still set to the rootIndex. 
        // If it is it means the left and right child were not larger or there are no children. 
        // If largest doesn't equal rootIndex then it means we need to swap. 
        if (largest != rootIndex) 
        { 
            int temp = arr[rootIndex]; 
            arr[rootIndex] = arr[largest]; 
            arr[largest] = temp; 
  
            // Since we performed a swap, we have to now check that the node the root was 
            // swapped to is not violating the max heap property. Meaning we need to now 
            // check its children to make sure it is larger than its left and right child. 
            // This recursively checks all the way down the tree til 
            // there are no more children to check.
            maxHeapify(arr, sizeOfHeap, largest); 
        } 
    } 
    
    //sort takes an integer array.
    public void sort(int arr[]) 
    { 
        
        // we need a variable to store the size of the heap which 
        // is also the size of the array. 
        int heapSize = arr.length-1; 
  
        
        
        //takes the array and the number of elements in the array to build our max heap. 
        buildMaxHeap(arr, heapSize);
  
        /*Here we have a for loop. It's going to start at the last index in the 
        heap and run down to 0. The goal here is to take the root, which is 
        located at arr[0] and switch it with the element in the last index. The 
        last element of the heap is going to be tracked by i. When the root is
        placed at the end of the heap, we drecrement the heapSize by 1 and then 
        call maxHeapify on the new root. This makes it so the heapify algorithm 
        does not take into account the old root. It's as if the last element in 
        the array no longer exists to the heapify algorithm. 
        We keep looping and swapping the largest element into the last position
        of the array that is available, which is tracked by the variable i. 
        */
        for (int i=arr.length-1; i>0; i--) 
        { 
            /* 
            We need to make a temp variable to store our current root, aka 
            largest element. We then place the element in the last position 
            of the array into the root arr[0]. We place the old root, aka the
            largest element, into the last position in the array. We decrement 
            the heapsize and we call maxHeapify so the new root becomes the second 
            largest element. We do this until the array is completely sorted. 
             */
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            
            heapSize = heapSize - 1;
            
            // call max heapify on the reduced heap 
            maxHeapify(arr, heapSize, 0); 
        } 
    } 
       
}
