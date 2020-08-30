package yueshow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "t_datetime")
public class MyEntity {

    @Id
    private Integer id;

    @Column(name = "username", length = 60)
    private String username;

    private java.util.Date myfield;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getMyfield() {
        return myfield;
    }

    public void setMyfield(Date myfield) {
        this.myfield = myfield;
    }
}
