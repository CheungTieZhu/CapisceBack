package com.capisceBack.model;

public class CompanyDescription {
    private String company;
    private String business;
    private String description;
    private String companyIcon;
    private int employeeNumber;
    private String ownerName;

    public  String getCompany(){
        return  company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public String getBusiness(){
        return business;
    }
    public void setBusiness(String business){
        this.business = business;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCompanyIcon(){
        return companyIcon;
    }
    public void setCompanyIcon(String companyIcon) {
        this.companyIcon = companyIcon;
    }
    public int getEmployeeNumber(){
        return employeeNumber;
    }
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
