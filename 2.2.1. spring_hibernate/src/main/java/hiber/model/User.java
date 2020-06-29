package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

//   @Column(name = "car_series")
//   private int car_series ;

//   @Column(name = "series")
//   private String series;

//   @OneToOne (optional=false, cascade=CascadeType.ALL)
//   @JoinColumn (name="series")
//   private Car series;

//   @OneToOne(cascade = CascadeType.ALL)
//   @JoinColumn(name = "series")
//   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

//   public String getSeries() {
//      return series;
//   }
//
//   public void setSeries(String series) {
//      this.series = series;
//   }
//
//   public Car getCar() {
//      return car;
//   }
//
//   public void setCar(Car car) {
//      this.car = car;
//   }

}
