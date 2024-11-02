package com.employee.em_project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Emrepository extends JpaRepository<Ementity,Integer>{
    
}
