/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.model;

import DB.Conexion;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author hp
 */

public class StudentDAO implements StudentDAOLocal {
    Connection con = null;
    @PersistenceContext
    private EntityManager em;
    @Override
    public void addStudent(Student student) {
                con= Conexion.connect();
                        em.persist(student);
    }

    @Override
    public void editStudent(Student student) {
        em.merge(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        em.remove(studentId);
    }
    
    @Override
    public Student getStudent (int studentId){
        return em.find(Student.class, studentId);        
    }
    
    @Override
    public List<Student> getAllStudents(){
        return em.createNamedQuery("Student.getAll").getResultList();
    }
}