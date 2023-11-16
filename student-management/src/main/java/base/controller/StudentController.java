package base.controller;

import base.model.Student;
import base.model.StudentForm;
import base.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @Value("${file_upload}")
    private String fileUpload;
    @GetMapping("")
    public ModelAndView showHome(){
        List<Student> students =studentService.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd(){
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("studentForm", new StudentForm());
        return modelAndView;
    }
    @PostMapping("/add")
    public String add(@ModelAttribute StudentForm studentForm, RedirectAttributes redirectAttributes){
        MultipartFile file = studentForm.getImage();
        String nameImage = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + nameImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Student student = new Student(studentForm.getId(), studentForm.getName(),studentForm.getAddress(), nameImage);
        studentService.add(student);
        redirectAttributes.addFlashAttribute("message", "Successfully Added");
        return "redirect:/student";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", studentService.findStudentById(id));
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, Student student, RedirectAttributes redirectAttributes){
        studentService.update(id, student);
        redirectAttributes.addFlashAttribute("message", student.getId() + "updated!");
        return "redirect:/student";
    }
    @GetMapping("/search")
    public ModelAndView showSearch(@RequestParam String e){
        List<Student> students;
        if(e.isEmpty()) {
            students = studentService.findAll();
        } else {
            students = studentService.findByName(e);
        }
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("students", students);
        return modelAndView;
    }
}
