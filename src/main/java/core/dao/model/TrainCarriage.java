package core.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "TrainCarriage")
public class TrainCarriage extends BaseEntity {
    @Column(name = "carriage_number", nullable = false)
    private int carriageNumber;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train trainForCarriage;

    @ManyToOne
    @JoinColumn(name = "carriage_id", nullable = false)
    private Carriage carriage;

    public TrainCarriage() {}

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public Train getTrainForCarriage() {
        return trainForCarriage;
    }

    public void setTrainForCarriage(Train trainForCarriage) {
        this.trainForCarriage = trainForCarriage;
    }

    public Carriage getCarriage() {
        return carriage;
    }

    public void setCarriage(Carriage carriage) {
        this.carriage = carriage;
    }
}
