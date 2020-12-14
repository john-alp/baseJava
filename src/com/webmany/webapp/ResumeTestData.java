package com.webmany.webapp;

import com.webmany.webapp.model.*;
import com.webmany.webapp.util.DateUtil;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {

        createResume("001", "John Lankaster");
    }

    public static void createResume(String uuid, String fullName){
        Resume resume = new Resume(uuid, fullName);

        resume.setContacts(ContactType.PHONE, "79851780898");
        resume.setContacts(ContactType.MAIL, "john1tanya@jmail.com");
        resume.setContacts(ContactType.SKYPE,"john@skype.com");
        resume.setContacts(ContactType.GITHUB,"john-alp");
        resume.setContacts(ContactType.HOME_PAGE, "www.john1tanya.com");
        resume.setContacts(ContactType.LINKEDIN, "john@linkedIn");

        DateUtil.of(15, Month.of(2));

//        Organization organization = new Organization("John",
//                "www.webmany.ru",
//                LocalDate.of(06, 05, 01),
//                LocalDate.of(19, 11, 20),
//                "engineer",
//                "super worker");
//int startYear, Month startMonth, int endYear, Month endMonth, String title, String description
        Organization organization = new Organization("John", "www.webmany.ru",
                new Organization.Position(2006, Month.JUNE, 2011, Month.FEBRUARY, "engineer", "super worker"),
                new Organization.Position(2011, Month.MARCH, "Super engineer", "super Mega worker"));

        List<Organization> jobs = new ArrayList<>();
        jobs.add(organization);

        //    List<Organization> universitets = new ArrayList<>();
        //    universitets.add(organization);

        List<String> sections = new ArrayList<>();
        sections.add("Great!");

        resume.setSections(SectionType.OBJECTIVE, new TextSection(" Developer"));
        resume.setSections(SectionType.EXPERIENCE, new OrganizationSection(jobs));
        resume.setSections(SectionType.PERSONAL,
                new TextSection(" Smart, handsome, moderately well-fed. In the full dawn of strength and years"));
        resume.setSections(SectionType.EDUCATION, new TextSection(" Three classes of a parochial school"));
        resume.setSections(SectionType.ACHIEVEMENT, new ListSection(sections));

        System.out.println(resume);

    }
}
