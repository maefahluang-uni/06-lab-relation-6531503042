package th.mfu.domain;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "performer")
public class Performer {



    //TODO: add attributes and annotation for Id, GeneratedValue
    // - id (Long)
    // - name (String)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Create fields attributes id, name
    private Long id;
    private String name;




    //TODO: add getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
