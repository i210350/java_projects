package app.entities;


import javax.persistence.*;

//@Entity
//@Table(name = "users")
public class User {

    //    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @Column(name = "name")
    private String name;

    //    @Column(name = "age")
    private Integer age;

    public User() {
    }

//    public User(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "name='" + name + '\'' +
//                ", age='" + age.toString() + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        User user = (User) o;
//
//        if (name != null ? !name.equals(user.name) : user.name != null) return false;
//        return age != null ? age.equals(user.age) : user.age == 0;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (age != null ? age.hashCode() : 0);
//        return result;
//    }
}
