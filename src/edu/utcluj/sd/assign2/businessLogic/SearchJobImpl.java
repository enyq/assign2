/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.businessLogic;

import edu.utcluj.sd.assign2.util.ConnectionManager;
import edu.utcluj.sd.assign2.dataLogic.Job;
import edu.utcluj.sd.assign2.brokerInterfaces.SearchJob;
import edu.utcluj.sd.assign2.dataLogic.Jobs;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Eniko
 */
public class SearchJobImpl extends UnicastRemoteObject implements SearchJob{

    public SearchJobImpl() throws RemoteException {
        
    }
    @Override
    public Jobs searchByDateInterval(Date from, Date until) throws RemoteException {
         PreparedStatement selectUsers = null;
         java.sql.Date fromDate = new java.sql.Date(from.getTime());
          java.sql.Date untilDate = new java.sql.Date(until.getTime());
         ConnectionManager cm = ConnectionManager.getInstance();
		Connection con = null;
		List<Job> result = new LinkedList<>();
		try {
			con = cm.getConnection();
			selectUsers = con
					.prepareStatement("SELECT * FROM jobs where deadline between ? and ?");
                        selectUsers.setDate(1, fromDate);
                        selectUsers.setDate(2, untilDate);
			ResultSet rs = selectUsers.executeQuery();
			while (rs.next()) {
				result.add(new Job(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6),rs.getString(7)));
            
			}
		} catch (SQLException e) {
                    e.printStackTrace();
			System.out.println("Connection failed at select");
		} finally {
			cm.returnConnection(con);
		}
        return new Jobs(result);
       
    }

    @Override
    public Jobs searchByCategorie(String categorie) throws RemoteException {
         System.out.println("Searching job in categorie " + categorie);
         PreparedStatement selectUsers = null;
         ConnectionManager cm = ConnectionManager.getInstance();
		Connection con = null;
		List<Job> result = new LinkedList<>();
		try {
			con = cm.getConnection();
			selectUsers = con
					.prepareStatement("SELECT * FROM jobs where category=?");
                        selectUsers.setString(1, categorie);
			ResultSet rs = selectUsers.executeQuery();
			while (rs.next()) {
				result.add(new Job(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getString(6),rs.getString(7)));
            
			}
		} catch (SQLException e) {
                    e.printStackTrace();
			System.out.println("Connection failed at select");
		} finally {
			cm.returnConnection(con);
		}
        return new Jobs(result);
    }
    
}
