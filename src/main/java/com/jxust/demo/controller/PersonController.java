package com.jxust.demo.controller;

import com.jxust.demo.dao.PersonRepository;
import com.jxust.demo.entity.Person;
import com.jxust.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {


    @Autowired
    PersonRepository personRepository;

//    @RequestMapping(value = "/hh")
//    public String hello(){
//
//        return "nihao";
//    }



    /**
     * 查找所有
     * @return
     */

    @GetMapping("/")
    public String Hello(){

        return "person;person,id;aliyun;yangliu";
    }

    @GetMapping("/person")
    public List<Person> personList(){
        List list=personRepository.findAll();

        return list;
    }


    /**
     * 添加一个人员
     *
     * @param name
     * @param age
     * @return
     */
//    @PostMapping(value = "/person")
//    public Person personAdd(@RequestBody Person person) {
//
////        Person person = new Person();
////        person.setName(name);
////        person.setAge(age);
//
//        return personRepository.save(person);
//    }
    //produces="application/json; charset=UTF-8"

//
    @PostMapping(value = "/person")
    public Person personAdd(@RequestParam("name") String name,
                            @RequestParam("age") Integer age) {

        System.out.println("name="+name);
        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        return personRepository.save(person);
    }

    /**
     * 查找一个
     * @return
     */
    @GetMapping("/person/{id}")
   // @GetMapping(value = "/person/{id}")
    public Person personFindOneById(@PathVariable Integer id){
       Person p= personRepository.findOne(id);
      // return p.getName()+p.getAge()+p.getId();
       return p;
    }

    /**
     * sans删除
     * @param id
     */
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        personRepository.delete(id);

    }
    /**
     * 更新一个
     */
   @PutMapping("/person/{id}")
    public Person update(@PathVariable("id") Integer id,
                         @RequestParam("name") String name,
                         @RequestParam("age") Integer age){
        Person p = new Person();
        p.setName(name);
        p.setId(id);
        p.setAge(age);
        Person save = personRepository.save(p);
        return save;
    }
    @GetMapping("age/{age}")
    public List<Person> findbyAge(@PathVariable  Integer age){

        return personRepository.findAllByAge(age);
    }
    @Autowired
    PersonService personService;
    @PostMapping("/person/two")
    public List<Person> insertTWO (){
        List<Person> people = personService.inserTWO();

        return people;
    }

}
