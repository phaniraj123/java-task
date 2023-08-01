package com.springexample.restdemo.controller;

import com.springexample.restdemo.KafkaServices.KafkaProducer;
import com.springexample.restdemo.Structure;
import com.springexample.restdemo.rep.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequestMapping("/structure")
public class StructureAPIService {

    @Autowired
    public StudentRepository studentRepository;
    public HashMap<String,Structure> map = new HashMap<>();


    private KafkaProducer kafkaProducer;

    public StructureAPIService(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/{studentID}") //expected value
    public ResponseEntity<Optional<Structure>> getStructureDetails(@PathVariable String studentID){

        return ResponseEntity.ok(studentRepository.findById(studentID));
    }


    @GetMapping
    public List<Structure> getAllDetails(){
        return (studentRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Structure> createStructureDetails(@RequestBody Structure s){
            map.put(s.getStudentID(),s);
//        Structure save = this.studentRepository.save(s);
        kafkaProducer.sendMessage(s);
       return ResponseEntity.ok(s);
    }
    @PutMapping
    public ResponseEntity<Structure> updateStructureDetails(@RequestBody Structure s){
         if (map.containsKey(s.getStudentID())){
        Structure k=map.get(s.getStudentID());
        studentRepository.deleteById(s.getStudentID());
        k.setStudentBranch(s.getStudentBranch());
        k.setStudentGPA(s.getStudentGPA());
             kafkaProducer.sendMessage(s);
        return ResponseEntity.ok(s);}
         else {return createStructureDetails(s);}




    }


    @DeleteMapping("/delete/{studentID}")
    public String deleteStructureDetails(@PathVariable String studentID){
        map.remove(studentID);
        studentRepository.deleteById(studentID);
        return "Deleted";
    }

    }


