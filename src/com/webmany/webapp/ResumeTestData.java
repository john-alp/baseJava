package com.webmany.webapp;

import com.webmany.webapp.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {

        Resume resume = new Resume("109542", "JohnSilver");

        resume.setContacts(ContactType.PHONE, "3050");
        resume.setContacts(ContactType.MAIL, "john1tanya@jmail.com");
        resume.setContacts(ContactType.SKYPE,"skype");
        resume.setContacts(ContactType.GITHUB,"john-alp");
        resume.setContacts(ContactType.HOME_PAGE, "www.john1tanya");
        resume.setContacts(ContactType.LINKEDIN, "linkedIn");


        Organization organization = new Organization("John",
                "www.yandex.ru",
                LocalDate.of(19, 10, 19),
                LocalDate.of(19, 11, 20),
                "engineer",
                "super worker");

        List<Organization> jobs = new ArrayList<>();
        jobs.add(organization);

        List<Organization> universitets = new ArrayList<>();
        universitets.add(organization);

        resume.setSections(SectionType.OBJECTIVE, new TextSection("developer"));
        resume.setSections(SectionType.EXPERIENCE, new OrganizationSection(jobs));

    }
}
