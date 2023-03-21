package com.nesterrovv.data;

import com.nesterrovv.application.CollectionManager;
import com.nesterrovv.inputUtils.IDGenerator;
import com.nesterrovv.wrappers.LocalDateTimeAdapter;
//import com.nesterrovv.application.IDGenerator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@XmlRootElement(name = "person")
public class Person
        implements Serializable, Comparable<Person> {

    private Long id;                        // not null, unique, auto-generated, greater then 0
    private String name;                    // not null, not empty
    private Coordinates coordinates;        // not null
    private LocalDateTime creationDate;     // not null, auto-generated
    private double height;                  // greater then 0
    private EyeColor eyeColor;              // not null
    private HairColor hairColor;            // may be null
    private Country nationality;            // not null
    private Location location;              // not null

    public Person() {}

    public Person(Long id, String name, Coordinates coordinates, LocalDateTime creationDate,
                  double height, EyeColor eyeColor, HairColor hairColor, Country nationality, Location location) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    @XmlElement
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @XmlElement
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @XmlElement
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @XmlElement
    public EyeColor getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    @XmlElement
    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    @XmlElement
    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @XmlElement
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        if (Double.compare(person.height, height) != 0) return false;
        if (!Objects.equals(id, person.id)) return false;
        if (!Objects.equals(name, person.name)) return false;
        if (!Objects.equals(coordinates, person.coordinates)) return false;
        if (!Objects.equals(creationDate, person.creationDate)) return false;
        if (eyeColor != person.eyeColor) return false;
        if (hairColor != person.hairColor) return false;
        if (nationality != person.nationality) return false;
        return Objects.equals(location, person.location);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 42 * result + (name != null ? name.hashCode() : 0);
        result = 52 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 62 * result + (creationDate != null ? creationDate.hashCode() : 0);
        temp = Double.doubleToLongBits(height);
        result = 72 * result + (int) (temp ^ (temp >>> 32));
        result = 72 * result + (eyeColor != null ? eyeColor.hashCode() : 0);
        result = 62 * result + (hairColor != null ? hairColor.hashCode() : 0);
        result = 52 * result + (nationality != null ? nationality.hashCode() : 0);
        result = 42 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }

    public int compareTo(Person another) {
        if (this.getId() - another.getId() > 0) {
            return 1;
        } else if (this.getId() - another.getId() == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public static class PersonBuilder {
        private CollectionManager collectionManager;
        private Long idBuilder;                        // not null, unique, auto-generated, greater then 0
        private String nameBuilder;                    // not null, not empty
        private Coordinates coordinatesBuilder;        // not null
        private LocalDateTime creationDateBuilder;     // not null, auto-generated
        private double heightBuilder;                  // greater then 0
        private EyeColor eyeColorBuilder;              // not null
        private HairColor hairColorBuilder;            // may be null
        private Country nationalityBuilder;            // not null
        private Location locationBuilder;              // not null

        //Конструктор с обязательными параметрами
        public PersonBuilder(CollectionManager collectionManager) {
            this.collectionManager = collectionManager;
        }

        //Методы с возвращающим типом Builder для необязательного параметра с, d, e, f,
        public PersonBuilder id() {
            this.idBuilder = IDGenerator.generateID();
            return this;
        }

        public PersonBuilder name(String name) {
            this.nameBuilder = name;
            return this;
        }

        public PersonBuilder coordinates(Coordinates coordinates) {
            this.coordinatesBuilder = coordinates;
            return this;
        }

        public PersonBuilder creationDate() {
            this.creationDateBuilder = LocalDateTime.now();
            return this;
        }

        public PersonBuilder height(double height) {
            this.heightBuilder = height;
            return this;
        }

        //Метод с возвращающим типом Good для генерации объекта
        public PersonBuilder eyeColor(EyeColor eyeColor) {
            this.eyeColorBuilder = eyeColor;
            return this;
        }

        public PersonBuilder hairColor(HairColor hairColor) {
            this.hairColorBuilder = hairColor;
            return this;
        }

        public PersonBuilder nationality(Country country) {
            this.nationalityBuilder = country;
            return this;
        }

        public PersonBuilder location(Location location) {
            this.locationBuilder = location;
            return this;
        }
        public Person build() {
            return new Person(this);
        }
    }

    public Person(PersonBuilder builder) {
        this.id = builder.idBuilder;
        this.name = builder.nameBuilder;
        this.coordinates = builder.coordinatesBuilder;
        this.creationDate = builder.creationDateBuilder;
        this.height = builder.heightBuilder;
        this.eyeColor = builder.eyeColorBuilder;
        this.hairColor = builder.hairColorBuilder;
        this.nationality = builder.nationalityBuilder;
        this.location = builder.locationBuilder;
    }

}
