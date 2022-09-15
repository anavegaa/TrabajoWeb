/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.model;

import java.util.List;

/**
 *
 * @author hp
 */

public interface StudentDAOLocal {

    void addStudent(Student student);

    void editStudent(Student student);

    void deleteStudent(int studentId);

    public Student getStudent(int studentId);

    public List<Student> getAllStudents();
    
}
