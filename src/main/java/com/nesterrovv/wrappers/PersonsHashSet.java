package com.nesterrovv.wrappers;

import com.nesterrovv.data.Person;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class PersonsHashSet {
    private Set<Person> personSet = new HashSet<>();

    public PersonsHashSet() {
    }

    public PersonsHashSet(Set<Person> personSet) {
        this.personSet = personSet;
    }

    @XmlElement(name = "person")
    public Set<Person> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<Person> personSet) {
        this.personSet = personSet;
    }
}