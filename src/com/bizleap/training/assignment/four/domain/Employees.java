package com.bizleap.training.assignment.four.domain;

public class Employees {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String age;
    private String title;
    private String salary;
    private Company workForCompany;

    public Employees(String id){
        super(id);
    }

    public Employees(String id,String name,String age, String title,String salary,String email, String phone,Company workForCompany) {
        super(id,name, email, phone);
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.email=email;
        this.setAge(age);
        this.setTitle(title);
        this.setSalary(salary);
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Company getWorkForCompany(){
        return workForCompany;
    }

    public void setWorkForCompany(Company workForCompany){
        this.workForCompany=workForCompany;
    }

    public String toString(){
        return this.id+","+this.name+","+this.age+","+this.title+","+this.salary+","+this.email+","+this.phone+"\n";
    }

}
