package com.bizleap.training.assignment.four.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Loader {
    List readEmployees(String employeeFileName) throws IOException;
    List readCompanies(String companyFileName)throws IOException;
}
