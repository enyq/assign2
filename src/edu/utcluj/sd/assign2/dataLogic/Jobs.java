/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.dataLogic;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eniko
 */
public class Jobs implements Serializable {
    
    public static final long serialVersionUID = 1L;
    private List<Job> list;
    
    public Jobs() {
        list = new LinkedList<Job>();
    }
    
    public Jobs(List<Job> initial) {
        list = new LinkedList<Job>(initial);
    }
    
    public void addJob(Job j) {
        list.add(j);
    }
    
    public Iterator<Job> getIterator() {
        return list.iterator();
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
