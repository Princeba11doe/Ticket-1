package com.healthcaremanagement.model;

import com.healthcaremanagement.model.Service.DoctorService;
import com.healthcaremanagement.model.Model.Doctor;
import com.healthcaremanagement.model.repository.DoctorRepositoryImpl;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        DoctorRepositoryImpl doctorRepository = new DoctorRepositoryImpl(sessionFactory);
        DoctorService doctorService = new DoctorService(doctorRepository);
        Scanner scan = new Scanner(System.in);
        Doctor doc = new Doctor();
        System.out.println("Enter First Name:");
        doc.setFirstName(scan.nextLine());
        System.out.println("Enter Last Name:");
        doc.setLastName(scan.nextLine());
        System.out.println("Enter Speciality:");
        doc.setSpecialty(scan.nextLine());
        System.out.println("Enter Email:");
        doc.setEmail(scan.nextLine());

        doctorService.createDoctor(doc);
        scan.close();
        sessionFactory.close();
        }
    }
