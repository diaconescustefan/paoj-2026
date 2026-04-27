package com.pao.laboratory04.exercise.service;

import com.pao.laboratory04.exercise.model.Student;
import com.pao.laboratory04.exercise.model.Subject;
import com.pao.laboratory04.exercise.exception.StudentNotFoundException;

import java.util.*;

/**
 * Serviciu Singleton - Gestionarea studentilor
 */
public class StudentService {
    
    private static StudentService instance = null;
    private List<Student> students;
    
    private StudentService() {
        this.students = new ArrayList<>();
    }
    
    public static synchronized StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }
    
    public void addStudent(String name, int age) {
        // Verifica daca studentul exista deja
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                throw new RuntimeException("Student cu acelasi nume exista deja!");
            }
        }
        Student student = new Student(name, age);
        students.add(student);
    }
    
    public Student findByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Student " + name + " nu gasit!");
    }
    
    public void addGrade(String studentName, Subject subject, double grade) {
        Student student = findByName(studentName);
        student.addGrade(subject, grade);
    }
    
    public void printAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Nu sunt studenti inregistrati!");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
            if (!s.getGrades().isEmpty()) {
                for (Map.Entry<Subject, Double> entry : s.getGrades().entrySet()) {
                    System.out.println("  - " + entry.getKey().getFullName() + ": " + entry.getValue());
                }
            }
        }
    }
    
    public void printTopStudents() {
        if (students.isEmpty()) {
            System.out.println("Nu sunt studenti inregistrati!");
            return;
        }
        List<Student> sorted = new ArrayList<>(students);
        sorted.sort((s1, s2) -> Double.compare(s2.getAverage(), s1.getAverage()));
        
        System.out.println("=== Top Studenti (dupa medie) ===");
        for (Student s : sorted) {
            System.out.println(s);
        }
    }
    
    public Map<Subject, Double> getAveragePerSubject() {
        Map<Subject, Double> averages = new HashMap<>();
        Map<Subject, Integer> count = new HashMap<>();
        
        for (Student s : students) {
            for (Map.Entry<Subject, Double> entry : s.getGrades().entrySet()) {
                Subject subject = entry.getKey();
                Double grade = entry.getValue();
                
                averages.put(subject, averages.getOrDefault(subject, 0.0) + grade);
                count.put(subject, count.getOrDefault(subject, 0) + 1);
            }
        }
        
        // Calculeaza media
        Map<Subject, Double> result = new HashMap<>();
        for (Subject subject : averages.keySet()) {
            result.put(subject, averages.get(subject) / count.get(subject));
        }
        
        return result;
    }
}
