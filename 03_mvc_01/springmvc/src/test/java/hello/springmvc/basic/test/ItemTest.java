package hello.springmvc.basic.test;

import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
//@Transactional
//class ItemTest {
//    @Autowired
//    EntityManager entityManager;
//
//    @Test
//    void test() {
//        // given
//        Item item = new Item();
//        entityManager.persist(item);
//
//        // when
//        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager); // (1)
//        QItem qItem = new QItem("i"); // (2)
//        Item found = queryFactory.selectFrom(qItem).fetchOne(); // (3)
//
//        // then
//        assertEquals(found, item); // (4)
//    }
//}
