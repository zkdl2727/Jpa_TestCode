package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {


    @Id @GeneratedValue
    private Long id;

    private String name;


    @OneToOne(mappedBy = "locker") //읽기전용.
    private Member member;

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
