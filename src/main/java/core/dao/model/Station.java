package core.dao.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Station", uniqueConstraints = @UniqueConstraint(columnNames = {"name", "suffix"}))
public class Station extends BaseEntity {
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "suffix", nullable = false, length = 45)
    private String suffix;

    @OneToMany(mappedBy = "station")
    private Set<Waypoint> waypoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
