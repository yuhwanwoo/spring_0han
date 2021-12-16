package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Entity는 JPA에서 관리하는 것임을 나타냄
public class Member {

    @Id
    private Long id;
    private String name;

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
