package web.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users_roles")
public class Users_Roles implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "users_id")
    private int users_id;

    @Column(name = "roles_id")
    private int roles_id;

    public Users_Roles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(int roles_id) {
        this.roles_id = roles_id;
    }
}
