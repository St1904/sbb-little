package core.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Carriage")
public class Carriage extends BaseEntity {
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "type", length = 45, nullable = false)
    private String type;

    @Column(name = "price", nullable = false)
    private BigDecimal priceForCarriage;

    public Carriage() {}

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

    public BigDecimal getPriceForCarriageType() {
        return priceForCarriage;
    }

    public void setPriceForCarriage(BigDecimal priceForCarriage) {
        this.priceForCarriage = priceForCarriage;
    }
}
