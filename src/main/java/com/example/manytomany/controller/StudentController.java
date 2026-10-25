package com.example.manytomany.controller;

import com.example.manytomany.dto.StudentDTO;
import com.example.manytomany.entity.Students;
import com.example.manytomany.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }


    @GetMapping("/all")
    public List<StudentDTO> getAllStudents() {

//        List<StudentDTO> studentDTOList = new ArrayList<>(); //[2]
//        StudentDTO studentDTO = new StudentDTO(); //{2}


        //java stores reference not coy
//      List<Students> studentsList =studentsRepository.findAll(); //[5,5,5,5,5]

//      for(Students student:studentsList){
//          StudentDTO studentDTO = new StudentDTO();
//          studentDTO.setId(student.getId());//{1}
//          studentDTO.setFullName(student.getFullName());
//          studentDTO.setAddress(student.getAddress());
//          studentDTO.setEmail(student.getEmail());
//          studentDTOList.add(studentDTO);//[]
//      }

        //streamapi

        List<StudentDTO> studentList = studentRepository.findAll()
                .stream()
                .map(student -> {
                            StudentDTO studentDTO = new StudentDTO();
                            studentDTO.setId(student.getId());
                            studentDTO.setFullName(student.getFullName());
                            studentDTO.setAddress(student.getAddress());
                            studentDTO.setEmail(student.getEmail());
                            return studentDTO;
                        }
                ).toList();

        //streamAPI forloop foreach
        return studentList;


        //two record rajendra sandip


        //euta jar  one   raksi +beer +pani

        //rejendra
        //thal masu chiura momo beer pani
        //one glass beer

    }
}
