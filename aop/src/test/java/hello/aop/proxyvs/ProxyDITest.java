package hello.aop.proxyvs;

import hello.aop.member.MemberService;


import hello.aop.member.MemberServiceImpl;
import hello.aop.proxyvs.code.ProxyDIAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
//@SpringBootTest(properties = {"spring.aop.proxy-target-class=false"}) //JDK 동적 프록시, DI 예외 발생
@SpringBootTest(properties = {"spring.aop.proxy-target-class=true"}) //CGLIB 프 록시, 성공
@Import(ProxyDIAspect.class)
public class ProxyDITest {
    @Autowired
    MemberService memberService; //JDK 동적 프록시 OK, CGLIB OK
    @Autowired
    MemberServiceImpl memberServiceImpl; //JDK 동적 프록시 X, CGLIB OK

    @Test
    void go() {
        log.info("memberService class={}", memberService.getClass());
        log.info("memberServiceImpl class={}", memberServiceImpl.getClass());
        memberServiceImpl.hello("hello");
    }
}
