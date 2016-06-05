package core.dao.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CarriageType")
public class CarriageType {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "type", length = 45, nullable = false)
    private String type;

    @Column(name = "price", nullable = false)
    private BigDecimal priceForCarriageType;

    public CarriageType() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigDecimal getPriceForCarriageType() {
        return priceForCarriageType;
    }

    public void setPriceForCarriageType(BigDecimal priceForCarriageType) {
        this.priceForCarriageType = priceForCarriageType;
    }
}
