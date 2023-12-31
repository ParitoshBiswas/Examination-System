package com.example.Exam;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController {
	
	@Autowired
	private ExamRepository examRepository;
	
	
   // to get all exam
	@GetMapping("/exam")
	public List<Exam> getAllExam(){
		return (List<Exam>)this.examRepository.findAll();
	}
   
   //to get details of a particular exam
	@GetMapping("/exam/{id}")
	public Exam getParticularExam(@PathVariable("id") int id){
 		 Optional<Exam> optional =  this.examRepository.findById(id);
		return optional.get();
	}

    //to add a new exam
	@PostMapping("/exam")
	public Exam addNewExam(@RequestBody Exam exam ){
		return this.examRepository.save(exam);
	}
	
	
	// to delete an exam
	   @DeleteMapping("/exam/{id}")
	    public String deleteExam(@PathVariable("id") int id){
		   int row =this.examRepository.deleteById(id);
		    return row + " row get deleted";  
		}

	
}
