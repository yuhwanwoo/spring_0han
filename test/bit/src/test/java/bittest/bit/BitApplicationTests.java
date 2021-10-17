package bittest.bit;

import bittest.bit.domain.Board;
import bittest.bit.domain.Member;
import bittest.bit.service.PersonService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class BitApplicationTests {

	@Autowired
	PersonService personService;



	@Test
	void tes() {
		Board board = new Board();
		board.setName("alx");

		personService.addPet(1L, "BB");



	}

}
