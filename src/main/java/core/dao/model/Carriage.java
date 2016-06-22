package core.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "Carriage")
public class Carriage extends BaseEntity {
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "type", length = 45, nullable = false)
    private String type;

    @Column(name = "price", nullable = false)
    private BigDecimal priceForCarriage;

    @OneToMany(mappedBy = "carriage")
    private Set<TrainCarriage> trainCarriages;

    public Carriage() {}

    public Carriage(String type, int capacity, BigDecimal priceForCarriage) {
        this.capacity = capacity;
        this.type = type;
        this.priceForCarriage = priceForCarriage;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPriceForCarriage() {
        return priceForCarriage;
    }

    public void setPriceForCarriage(BigDecimal priceForCarriage) {
        this.priceForCarriage = priceForCarriage;
    }

    @Override
    public String toString() {
        return "Carriage{" +
                "capacity=" + capacity +
                ", type='" + type + '\'' +
                ", priceForCarriage=" + priceForCarriage +
                '}';
    }
}
