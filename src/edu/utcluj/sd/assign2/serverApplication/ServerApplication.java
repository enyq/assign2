/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.serverApplication;

import edu.utcluj.sd.assign2.brokerInterfaces.PostJob;
import edu.utcluj.sd.assign2.brokerInterfaces.SearchJob;
import edu.utcluj.sd.assign2.businessLogic.PostJobImpl;
import edu.utcluj.sd.assign2.businessLogic.SearchJobImpl;
import java.rmi.AlreadyBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eniko
 */
public class ServerApplication {

    static final int port1 = 1099;
     static final int port2 = 1100;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(System.getSecurityManager() == null) {
              System.setSecurityManager (new SecurityManager());
        }
        try {
            String searchEndPointName = "searchJob";
            String postEndPointName = "postJob";
            SearchJob searchJob = new SearchJobImpl();
             PostJob postJob = new PostJobImpl();
      
            Registry regSearch = LocateRegistry.createRegistry(port1);
             Registry regPost = LocateRegistry.createRegistry(port2);
            regSearch.rebind(searchEndPointName, searchJob);
            regPost.rebind(postEndPointName, postJob);
            System.out.println("Server Application has started...");
            
        } catch(RemoteException e) {
            Logger.getLogger(ServerApplication.class.getName()).log(Level.SEVERE, null, e);
        }
       
    }
    
}
