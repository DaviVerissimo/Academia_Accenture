package acc.br.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import acc.br.student.model.Student;

import acc.br.student.service.StudentService;

//creating RestController

@RestController

public class StudentController {
//fazer em react  versão que inseri dados e consulta dados.
    //autowired the StudentService class

    @Autowired

    StudentService studentService;


    //creating a get mapping that retrieves all the students detail from the database

    @GetMapping("/student")

    private List<Student> getAllStudent() {

        return studentService.getAllStudent();

    }


    //creating a get mapping that retrieves the detail of a specific student

    @GetMapping("/student/{id}")

    private Student getStudent(@PathVariable("id") int id) {

        return studentService.getStudentById(id);

    }


    //creating a delete mapping that deletes a specific student

    @DeleteMapping("/student/{id}")

    private void deleteStudent(@PathVariable("id") int id) {

        studentService.delete(id);

    }


    //creating post mapping that post the student detail in the database

    @PostMapping("/student")

    private int saveStudent(@RequestBody Student student) {

        studentService.saveOrUpdate(student);

        return student.getId();

    }

    @PutMapping("/student/{id}")

    public int updateStudent(@RequestBody Student student, @PathVariable("id") int id) {

        if (student.getId() != id) {
            return -1;
        }

        studentService.saveOrUpdate(student);
        return student.getId();
    }
}


