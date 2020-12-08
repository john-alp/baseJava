package com.webmany.webapp;

import com.webmany.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {

        Resume resume = new Resume("109542", "JohnSilver");

        resume.setContacts(ContactType.PHONE, "556672233322");
        resume.setContacts(ContactType.MAIL, "john1tanya@jmail.com");
        resume.setContacts(ContactType.SKYPE,"skype");
        resume.setContacts(ContactType.GITHUB,"john-alp");
        resume.setContacts(ContactType.HOME_PAGE, "www.john1tanya");
        resume.setContacts(ContactType.LINKEDIN, "linkedIn");


        Organization organization = new Organization("John",
                "www.webmany.ru",
                LocalDate.of(19, 10, 19),
                LocalDate.of(19, 11, 20),
                "engineer",
                "super worker");

        List<Organization> jobs = new ArrayList<>();
        jobs.add(organization);

    //    List<Organization> universitets = new ArrayList<>();
    //    universitets.add(organization);

        List<String> sections = new ArrayList<>();
        sections.add("Great!");

        resume.setSections(SectionType.OBJECTIVE, new TextSection("Developer"));
        resume.setSections(SectionType.EXPERIENCE, new OrganizationSection(jobs));
        resume.setSections(SectionType.PERSONAL,
                new TextSection("Smart, handsome, moderately well-fed. In the full dawn of strength and years"));
        resume.setSections(SectionType.EDUCATION, new TextSection("Three classes of a parochial school"));
        resume.setSections(SectionType.ACHIEVEMENT, new ListSection(sections));

        System.out.println(resume);

//        for(SectionType sectionType : SectionType.values()) {
//            System.out.println(sectionType);
//        }
//        System.out.println();
//        for(ContactType contactType : ContactType.values()) {
//            System.out.println(contactType);
//        }

    }
}
