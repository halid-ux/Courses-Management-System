package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/allTeachers")
    public String getTeachersPage(Model model)
    {
        List<Teacher> teacherList = teacherService.findAll();
        model.addAttribute("teacherList",teacherList);
        model.addAttribute("bodyContent","listTeachers");
        return "index";
    }
    @GetMapping("/addTeacher")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addTeacher()
    {
        return "add-teacher";
    }
    @PostMapping("/add")
    public String saveTeacher(@RequestParam(required = false) String teacherId,
                              @RequestParam String name,
                              @RequestParam String surname) {
        if(teacherId != null) {
            Teacher zemi = teacherService.findById(Long.parseLong(teacherId));
            zemi.getTeacherFullName().setName(name);
            zemi.getTeacherFullName().setSurname(surname);
            teacherService.save(zemi);
        }
        else {
            teacherService.addTeacher(name, surname);
        }
        return "redirect:/teachers/allTeachers";
    }
    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable String id) {
        teacherService.deleteTeacher(Long.parseLong(id));
        return "redirect:/teachers/allTeachers";
    }
    @GetMapping("/edit/{id}")
    public String editTeachers(@PathVariable String id, Model model) {
        Teacher toEdit = teacherService.findById(Long.parseLong(id));
        model.addAttribute("teacher", toEdit);
//        catch(TeacherNotFoundException ex)
//        {
//            return "redirect:/teachers?error=" + ex.getMessage();
//        }
        return "add-teacher";
    }

}
