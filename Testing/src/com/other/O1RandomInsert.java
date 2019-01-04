package com.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
	 * insert(x)
	1) Check if x is already present by doing a hash map lookup.
	2) If not present, then insert it at the end of the array.
	3) Add in hash table also, x is added as key and last array index as index.
	
	remove(x)
	1) Check if x is present by doing a hash map lookup.
	2) If present, then find its index and remove it from hash map.
	3) Swap the last element with this element in array and remove the last element.
	Swapping is done because the last element can be removed in O(1) time.
	4) Update index of last element in hash map.
	
	getRandom()
	1) Generate a random number from 0 to last index.
	2) Return the array element at the randomly generated index.
	
	search(x)
	Do a lookup for x in hash map.
 * @author kkarnam
 *
 */

public class O1RandomInsert {
	
	ArrayList<Integer> arr;
	HashMap<Integer, Integer> hash;
	Random rand = new Random();
	
    public O1RandomInsert() {
        arr = new ArrayList<Integer>();
	    hash = new HashMap<Integer, Integer>();
    }

    void add(int x) 
    { 
       // If ekement is already present, then noting to do 
       if (hash.get(x) != null) 
           return; 
   
       // Else put element at the end of arr[] 
       int s = arr.size(); 
       arr.add(x); 
   
       // And put in hash also 
       hash.put(x, s); 
    } 
   
    // A Theta(1) function to remove an element from MyDS 
    // data structure 
    void remove(int x) 
    { 
        // Check if element is present 
        Integer index = hash.get(x); 
        if (index == null) 
           return; 
   
        // If present, then remove element from hash 
        hash.remove(x); 
   
        // Swap element with last element so that remove from 
        // arr[] can be done in O(1) time 
        int size = arr.size(); 
        Integer last = arr.get(size-1); 
        Collections.swap(arr, index,  size-1); 
   
        // Remove last element (This is O(1)) 
        arr.remove(size-1); 
   
        // Update hash table for new index of last element 
        hash.put(last, index); 
     } 
   
     // Returns a random element from MyDS 
     int getRandom() 
     { 
        // Find a random index from 0 to size - 1 
        Random rand = new Random();  // Choose a different seed 
        int index = rand.nextInt(arr.size()); 
   
        // Return element at randomly picked index 
        return arr.get(index); 
     } 
}
