package com.estramipyme.estramipyme_API.Repositories;

import com.estramipyme.estramipyme_API.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository <Teacher, Long> {
}
