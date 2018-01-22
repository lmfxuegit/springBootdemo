package com.jxust.demo.dao;

import com.jxust.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {
    List<Person> findAllByAge(Integer age);
}
