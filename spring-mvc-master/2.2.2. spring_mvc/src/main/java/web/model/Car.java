package web.model;


import java.util.Objects;

public class Car {
    private Long id;
    private String brand;
    private String model;
    private String serial;

    public Car(Long id, String brand, String model, String serial) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "brand = " + getBrand() + "\n\r" +
                "model = " + getModel() + "\n\r" +
                "serial = " + getSerial() + "\n\r" ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Car)) return false;
        Car user = (Car) o;
        return Objects.equals(getSerial(), user.getSerial());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerial());
    }

}
