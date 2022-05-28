package ru.barom.spring_2022.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import ru.barom.spring_2022.domain.Student;
import ru.barom.spring_2022.repository.StudentRepository;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/all")
    public ModelAndView getStudents() {
        ModelAndView modelAndView = new ModelAndView("student/all");
        modelAndView.addObject("students", studentRepository.findAll());
        return modelAndView;
    }

    @GetMapping("/form")
    public String getStudentForm(@RequestParam(required = false) Long id, Model model) {
        Student student = new Student();
        if (id != null) {
            student = studentRepository.findById(id).get();
        }
        model.addAttribute("student", student);
        return "student/form";
    }

    @PostMapping
    public RedirectView saveStudent(@ModelAttribute Student student) {
        studentRepository.save(student);
        return new RedirectView("/student/all");
    }

    @GetMapping("/delete")
    public ModelAndView delStudent(@RequestParam Long id) {
        studentRepository.deleteById(id);
        return getStudents();
    }

}
