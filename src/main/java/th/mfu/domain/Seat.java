package th.mfu.domain;

import javax.annotation.Generated;
import javax.persistence.*;


@Entity
@Table(name = "seat")
public class Seat {



    //TODO: add attributes and annotation for Id, GeneratedValue
    // - id (Long)
    // - number (String)
    // - zone (String)
    // - booked (boolean)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String zone;
    private boolean booked;


    public Seat(String number, String zone, boolean booked, Concert concert) {
        this.number = number;
        this.zone = zone;
        this.booked = booked;
        this.concert = concert;
    }

    public Seat() {
        // Default Constructor
    }

    //TODO: add many-to-one relationship to concert with cascade type CascadeType.MERGE
    @ManyToOne(cascade = CascadeType.MERGE)
    private Concert concert;

    // Getter and Setter methods for all attributes

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }
}