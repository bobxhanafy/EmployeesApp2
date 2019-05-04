package com.example.employeesapp.Model;

public class EmpModel {
    private int id;
    private String Name;
    private String Role;
    private String BirthDate;
    private String Salary;
    private String Gender;
    private String Address;

    //Empty constructor
    public EmpModel(){

    }

    //constructor
    public EmpModel(int id,String Name,String Role,String BirthDate,String Salary,String Gender,String Address){
        this.id=id;
        this.Name=Name;
        this.Role=Role;
        this.BirthDate=BirthDate;
        this.Salary=Salary;
        this.Gender=Gender;
        this.Address=Address;
    }
    //Getters && Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
