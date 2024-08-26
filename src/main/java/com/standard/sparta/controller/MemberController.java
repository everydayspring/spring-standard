package com.standard.sparta.controller;

import com.standard.sparta.dto.MemberCreateRequestDto;
import com.standard.sparta.dto.MemberDto;
import com.standard.sparta.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    // 1. 속성
    private final MemberService memberService;

    // 2. 생성자
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 3. 메소드

    /**
     * 1. 회원 생성을 위한 뷰를 반환
     * @return view 이름 반환
     */
    @GetMapping("/create-form")
    public String createMemberView() {
        return "member-create-form";
    }

    /**
     * 1-1. 회원 생성 API
     * @param request DTO 객체
     * @return view 이름 반환
     */
    @PostMapping()
    public String createMemberAPI(@ModelAttribute MemberCreateRequestDto request) {
        memberService.createMember(request);
        return "redirect:/member/list-form";
    }

    /**
     * 회원 목록 확인을 위한 뷰 반환
     * @param model MVC model 객체
     * @return view 이름 반환
     */
    @GetMapping("/list-form")
    public String memberListView(Model model) {
        List<MemberDto> memberDtoList = memberService.getMemberList();
        model.addAttribute("members", memberDtoList);
        return "member-list-form";
    }
}
