/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.brokerInterfaces;

import edu.utcluj.sd.assign2.dataLogic.Job;
import edu.utcluj.sd.assign2.dataLogic.Jobs;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eniko
 */
public interface SearchJob extends Remote, Serializable{
    
    public Jobs searchByDateInterval(Date from, Date until) throws RemoteException;
    public Jobs searchByCategorie(String categorie) throws RemoteException;
}
