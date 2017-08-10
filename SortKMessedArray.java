import java.io.*;
import java.util.*;

class Solution {

  static int[] sortKMessedArray(int[] arr, int k) {
    // your code goes here
    // [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
    // i=k=2
    // 1, 2, 3, 4, 5, 7
    // i=k+k+1,  klogk
    int n = arr.length; 
    if (n<=1) return arr; 
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k); 
    
    //insert takes O(logK)
    for (int i=0;i<=k; i++)
      minHeap.add(arr[i]);
    
    for (int i=k+1; i<n; i++) {
      arr[i-(k+1)] = minHeap.poll(); 
      minHeap.add(arr[i]); 
    }
    
    // [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
    for(int i=0; i<=k; i++){
      arr[n-k-1+i] = minHeap.poll();
    }
    
    return arr; 
  }

  public static void main(String[] args) {

  }

}
