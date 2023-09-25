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

    public Concert(Long id, String title, Date date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Concert() {
        //Default Constructure
    }


    //TODO: add one-to-one relationship to performer with CascadeType.ALL
    @OneToOne( cascade =  CascadeType.ALL)
    private Concert Performer;

    
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
}
