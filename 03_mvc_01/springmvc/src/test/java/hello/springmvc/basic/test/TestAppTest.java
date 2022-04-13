package hello.springmvc.basic.test;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestAppTest {

    @Test
    public void distinct_test() {
        User user1 = new User("서울", "kim");
        User user2 = new User("부산", "oh");
        User user3 = new User("서울", "yu");
        User user4 = new User("서울", "choi");
        User user5 = new User(null, "kang");

        ArrayList<User> users = Lists.newArrayList(user1, user2, user3, user4, user5);

        List<User> collects = users.stream().distinct().collect(Collectors.toList());

        for (User collect : collects) {
            System.out.println("collect. = " + collect.getName());
        }
    }

//    @Test
//    public void projections() throws Exception {
//        //given
//        Team teamA = new Team("teamA");
//        em.persist(teamA);
//        Member m1 = new Member("m1", 0, teamA);
//        Member m2 = new Member("m2", 0, teamA);
//        em.persist(m1);
//        em.persist(m2);
//        em.flush();
//        em.clear();
//        //when
//        List<UsernameOnly> result =
//                memberRepository.findProjectionsByUsername("m1");
//        //then
//        Assertions.assertThat(result.size()).isEqualTo(1);
//    }

}