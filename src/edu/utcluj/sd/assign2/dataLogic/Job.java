/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utcluj.sd.assign2.dataLogic;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Eniko
 */
public class Job implements Serializable{

    
    private int id;
    private String title;
    private String company;
    private String category;
    private Date deadline;
    private String contactDetails;

    static final long serialVersionUID = 42L;
    
   
    public Job(int id, String title, String company, String category, Date deadline, String contactDetails, String specification) {
        this.id = id;
        this.title = title;
        this.company = company;
        this.category = category;
        this.deadline = deadline;
        this.contactDetails = contactDetails;
        this.specification = specification;
    }
    private String specification;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", title=" + title + ", company=" + company + ", category=" + category + ", deadline=" + deadline + ", contactDetails=" + contactDetails + ", specification=" + specification + '}';
    }
    
    
}
