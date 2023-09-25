package th.mfu.domain;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "concert")
public class Concert {




    //TODO: add attributes and annotation for Id, GeneratedValue
    // - id (Long)
    // - title (String)
    // - date (Date)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date date;

    public Concert(Long id, String title, Date date, Performer performer) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.performer = performer;
    }

    public Concert() {
        //Default Constructure
    }

    //TODO: add one-to-one relationship to performer with CascadeType.ALL
    @OneToOne( cascade =  CascadeType.ALL)
    private Performer performer;

    
    //TODO: add getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Performer getPerformer() {
        return performer;
    }

    public void setPerformer(Performer performer) {
        this.performer = performer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static boolean isPreset() {
        return false;
    }
}
