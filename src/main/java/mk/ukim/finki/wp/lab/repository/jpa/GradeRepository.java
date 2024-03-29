package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Long> {
    Grade findByStudentAndCourse(Student s, Course c);
    List<Grade> findAllByCourse(Course c);
    List<Grade> findByTimestampBetweenAndCourse(LocalDateTime from, LocalDateTime to,Course c);
    void deleteAllByCourse(Course c);
}
