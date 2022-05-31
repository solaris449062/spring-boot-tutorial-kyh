package spark.springpractice.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spark.springpractice.repository.MemberRepository;
import spark.springpractice.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
