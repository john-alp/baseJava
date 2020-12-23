package com.webmany.webapp.model;

 import java.io.Serializable;
 import java.util.*;


public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;

    private final String uuid;
    private final String fullName;

    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }
    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }
    public Section getSection(SectionType type) {
        return sections.get(type);
    }


    public void setContacts(ContactType type, String value) {
        contacts.put(type, value);
    }
    public void setSections(SectionType sectionType, Section section) {
        sections.put(sectionType, section);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);

    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

//    @Override
//    public String toString() {
//        System.out.println(uuid + " " + fullName);
//        System.out.println();
//        for (Map.Entry<ContactType, String> pair2 : contacts.entrySet()) {
//            System.out.println(pair2);
//        }
//        System.out.println();
//        for (Map.Entry<SectionType, Section> pair : sections.entrySet()){
//            System.out.println(pair);
//        }
//      //  return uuid + '(' + fullName + ')';
//        return " ";
//    }

    @Override
    public String toString() {
        System.out.println(uuid + " (" + fullName + ')');
        for (Map.Entry<ContactType, String> pair : contacts.entrySet()) {
            System.out.println(pair.getKey().getTitle() + ": " + pair.getValue());
        }
        for (Map.Entry<SectionType, Section> pair : sections.entrySet()) {
            System.out.println(pair.getKey().getTitle() + ": " + pair.getValue());
        }
        return "";
    }

    @Override
    public int compareTo(Resume o) {
        int cmp = fullName.compareTo(o.fullName);
        return cmp != 0 ? cmp : uuid.compareTo(o.uuid);
    }
}
