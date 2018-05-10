package com.bizleap.training.assignment.four.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bizleap.training.assignment.four.impl.Loader;
import com.bizleap.training.assignment.four.domain.Company;
import com.bizleap.training.assignment.four.domain.Employees;

public class LoaderImpl implements Loader{
    private Employees toEmployee(String line){
        Employees employee;
        String[] tokens=line.split(",");
        employee=new Employees(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],new Company(tokens[7]));
        employee.setName(tokens[1]);
        employee.setAge(tokens[2]);
        employee.setTitle(tokens[3]);
        employee.setSalary(tokens[4]);
        employee.setEmail(tokens[5]);
        employee.setPhone(tokens[6]);
        employee.setWorkForCompany(new Company(tokens[7]));
        return employee;
    }

    private Company toCompany(String line){
        Company company;
        String[] tokens=line.split(",");
        company=new Company(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5]);
        company.setName(tokens[1]);
        company.setEmail(tokens[2]);
        company.setPhone(tokens[3]);
        company.setAddress(tokens[4]);
        company.setCEO(tokens[5]);
        return company;
    }

    public List<Employees> readEmployees(String employeeFileName) throws IOException{
        List<Employees> employeeList=new ArrayList();
        String employeeData;
        BufferedReader br=new BufferedReader(new FileReader(employeeFileName));
        while((employeeData=br.readLine())!=null){
            employeeList.add(toEmployee(employeeData));
        }
        br.close();
        return employeeList;
    }

    public List<Company> readCompanies(String companyFileName) throws IOException{
        List<Company> companyList=new ArrayList();
        String companyData;
        BufferedReader br=new BufferedReader(new FileReader(companyFileName));
        while((companyData=br.readLine())!=null){
            companyList.add(toCompany(companyData));
        }
        br.close();
        return companyList;
    }
}
