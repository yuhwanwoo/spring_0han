package bittest.bit.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @OneToMany(mappedBy = "member")
    private List<Board> boards = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public Set<Board> getPets() {
        //FIXME
        Set<Board> board_set = new HashSet<>();
        for (Board board : boards) {
            board_set.add(board);
        }
        return board_set;
    }

}
