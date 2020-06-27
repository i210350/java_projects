package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "name")
    private String firstName;

    @OneToOne (optional=false, mappedBy="series")
    private User owner;

//    @Column(name = "series")
//    private int series;
}
