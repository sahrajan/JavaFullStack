package com.sah.app.rest.repo;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.sah.app.rest.model.employee;


public interface employeeRepo extends JpaRepository <employee, Long> {

}
