package bittest.bit.domain;

import javax.persistence.*;

public @Entity
class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Member member;

    public String getOwnerName() {
        String firstname = member.getFirstName();
        return firstname;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public static Board createVote(Member member, String petName) {
        Board board = new Board();
        board.setMember(member);
        board.setName(petName);

        return board;
    }

}
