package core.dao.model;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    //useless
    /*public void setId(long id) {
        this.id = id;
    }*/
}
