/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.businessLogic;

import edu.utcluj.sd.assign2.util.ConnectionManager;
import edu.utcluj.sd.assign2.dataLogic.Job;
import edu.utcluj.sd.assign2.brokerInterfaces.PostJob;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Eniko
 */
public class PostJobImpl extends UnicastRemoteObject implements PostJob{

    public PostJobImpl() throws RemoteException {
        
    }
    @Override
    public void postJob(Job job) throws RemoteException {
        PreparedStatement insertJob = null;
        java.sql.Date deadline = new java.sql.Date(job.getDeadline().getTime());
        ConnectionManager cm = ConnectionManager.getInstance();
		Connection con = null;
		
		try {
			con = cm.getConnection();
			insertJob = con
					.prepareStatement("insert into jobs values (?,?,?,?,?,?,?)");
			 insertJob.setInt(1, job.getId());
            insertJob.setString(2, job.getTitle());
            insertJob.setString(3, job.getCompany());
            insertJob.setString(4, job.getCategory());
            insertJob.setDate(5, deadline);
            insertJob.setString(6, job.getContactDetails());
            insertJob.setString(7, job.getSpecification());
            insertJob.executeUpdate();
            
		} catch (SQLException e) {
			System.out.println("Connection failed at insert");
		} finally {
			cm.returnConnection(con);
		}
		
    }
}
