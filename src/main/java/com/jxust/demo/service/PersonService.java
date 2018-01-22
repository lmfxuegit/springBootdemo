package com.jxust.demo.service;

import com.jxust.demo.dao.PersonRepository;
import com.jxust.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
@Transactional
   public List<Person> inserTWO(){
       List list= new ArrayList();
       Person person=new Person();
       person.setAge(24);
       person.setName("qiuya");
       personRepository.save(person);
       System.out.println(1/0);
       Person person2=new Person();
       person2.setAge(25);
       person2.setName("yuanhua");
       personRepository.save(person2);

       list.add(person);
       list.add(person2);
       return list;
   }
}
