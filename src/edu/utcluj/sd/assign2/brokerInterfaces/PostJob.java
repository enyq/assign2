/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.brokerInterfaces;

import edu.utcluj.sd.assign2.dataLogic.Job;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Eniko
 */
public interface PostJob extends Remote,Serializable{
    
    public void postJob(Job j) throws RemoteException;
    
}

