package com.husna.ogrenciserver.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "LESSONS")
public class Lesson {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LESSONS_SEQ_GENERATOR")
    @SequenceGenerator(name = "LESSONS_SEQ_GENERATOR", sequenceName = "LESSONS_SEQ", allocationSize = 1)
    @Column(name = "LESSON_ID")
    private int lessonId;

    @Column(name = "LESSON_NAME")
    private String lessonName;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

}
