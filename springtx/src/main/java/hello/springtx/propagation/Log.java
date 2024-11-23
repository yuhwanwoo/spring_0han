package hello.springtx.propagation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Log {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    public Log() {
    }
    public Log(String message) {
        this.message = message;
    }
}
