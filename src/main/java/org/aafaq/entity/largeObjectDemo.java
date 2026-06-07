package org.aafaq.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "large_object_demo")
public class largeObjectDemo {

    @Id
    private int studentId;

    @Lob
    @Column(name = "student_image", columnDefinition = "LONGBLOB")
    private byte[] studentImage;

    public largeObjectDemo() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public byte[] getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(byte[] studentImage) {
        this.studentImage = studentImage;
    }
}
