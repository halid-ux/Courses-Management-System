package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Teacher;
import mk.ukim.finki.wp.lab.model.TeacherFullName;
import mk.ukim.finki.wp.lab.repository.jpa.TeacherRepository;
import mk.ukim.finki.wp.lab.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    TeacherRepository teacherRepository;


    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAllByOrderById();
    }

    @Override
    public Teacher findById(Long ID) {
        return teacherRepository.findById(ID).isPresent() ? teacherRepository.findById(ID).get():null;
    }

    @Override
    public Teacher addTeacher(String name, String surname) {
        Teacher add = new Teacher(new TeacherFullName(name,surname));
        teacherRepository.save(add);
        return add;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void save(Teacher t) {
        teacherRepository.save(t);
    }

}
