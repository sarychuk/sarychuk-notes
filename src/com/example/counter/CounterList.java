package com.example.counter;

import java.util.ArrayList;

/**
 * Used to store and manage the list of Counters. Responsible for saving and
 * loading the data from the filesystem.
 */
public class CounterList extends ArrayList<CounterModel> {
    
	// singleton to make sure that only one ArrayList exists
    private static CounterList singletonCounterList;
    
    // singleton constructor
    private CounterList(){}
    
    // singleton getInstance method to create new CounterArray
    public static CounterList getList(){
            if (singletonCounterList == null){
                    singletonCounterList = new CounterList();
            }
            return singletonCounterList;
    }
    
}
