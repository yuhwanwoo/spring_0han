package hello.servlet.AconfirmTest;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
public class UserDTO extends Option{

    @GeneratedValue
    @Id
    private Long id;
    private String username;

    public UserDTO() {
    }

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "code='" + code + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String test() {
        return null;
    }
}
