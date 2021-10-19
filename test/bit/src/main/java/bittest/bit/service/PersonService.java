package bittest.bit.service;

import bittest.bit.domain.Member;
import bittest.bit.domain.Board;
import bittest.bit.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = true)
public class PersonService {

    private EntityManager entityManager;

    @Autowired
    public PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void addPet(Long personId, String petName) {
        //FIXME
        try {
            Member member = entityManager.find(Member.class, personId);

            if(member == null) {
                throw new PersonNotFoundException();
            }

            Board board = Board.createVote(member, petName);

            entityManager.persist(board);


        } catch (Exception e) {
            throw new PersonNotFoundException();
        }

    }

}
