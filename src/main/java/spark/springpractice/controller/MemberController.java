package spark.springpractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spark.springpractice.service.MemberService;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    //    @Autowired
//    public MemberController(MemberService memberService) {
//        this.memberService = memberService;
//    }
}
