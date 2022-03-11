package com.cg.classrosterfullstackapp.students;

import com.cg.classrosterfullstackapp.students.exceptions.BadRequestException;
import com.cg.classrosterfullstackapp.students.exceptions.StudentNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) throws StudentNotFoundException{
        boolean exists = studentExists(id);
        if(!exists){
            throw new StudentNotFoundException("Error...Student with id " + id + " not found.");
        }
        return studentRepository.findById(id).get();
    }

    public void createNewStudent(Student student) throws BadRequestException{
        boolean exists = emailAlreadyExists(student.getEmail());
        if(exists){
            throw new BadRequestException("Error... Email of " + student.getEmail() + " already exists.");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) throws StudentNotFoundException{
        boolean exists = studentExists(id);
        if(!exists){
            throw new StudentNotFoundException("Error...Student with id " + id + " not found.");
        }
        studentRepository.deleteById(id);
    }
    public void updateStudent(Student student, Long studentId) throws StudentNotFoundException{
        boolean exists = studentExists(studentId);
        if(!exists){
            throw new StudentNotFoundException("Error...Student with id " + studentId + " not found.");
        }
        Student studentToUpdate = studentRepository.getById(studentId);
        studentToUpdate.setName(student.getName());
        studentToUpdate.setEmail(student.getEmail());
        studentToUpdate.setGender(student.getGender());
        studentRepository.save(studentToUpdate);
    }

    private boolean emailAlreadyExists(String email){
        Student student = studentRepository.findStudentByEmail(email);
        if(student == null){
            return false;
        }
        return true;
    }

    private boolean studentExists(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return true;
        }
        return false;
    }


}
