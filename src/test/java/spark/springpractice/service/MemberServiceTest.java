package spark.springpractice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import spark.springpractice.domain.Member;
import spark.springpractice.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("John");

        // when
        Long savedId = memberService.join(member);

        // then
        Member result = memberService.findOne(savedId).get();
        assertThat(member.getName()).isEqualTo(result.getName());

    }

    @Test
    public void noDuplicateUsername() {
        // given
        Member member1 = new Member();
        member1.setName("John");

        Member member2 = new Member();
        member2.setName("John");

        // when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("The username already exists");

        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException exception) {
            assertThat(exception.getMessage()).isEqualTo("The username already exists");
        }
        */

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}