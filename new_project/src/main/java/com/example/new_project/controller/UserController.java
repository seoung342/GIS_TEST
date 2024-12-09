package com.example.new_project.controller;

import com.example.new_project.entity.Account;
import com.example.new_project.entity.User;
import com.example.new_project.service.AccountService;
import com.example.new_project.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Log4j2 // 로그 표시
@RequiredArgsConstructor // @Autowired 대신
@RequestMapping("/user") // 앞에 붙이는거 security 쓸때 편함
public class UserController {

    private final UserService userService;
    private final AccountService accountService;

    @GetMapping("/login")
    public String login() {
        log.info("로그인 페이지");
        return "user/login";
    }

    @GetMapping("/register")
    public String register() {
        log.info("회원 가입 페이지");
        return "user/register";
    }

    @GetMapping("/info")
    public String info() {
        log.info("정보 수정 페이지");
        return "user/info";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        log.info("로그아웃");
        return "redirect:/";
    }

    @PostMapping("/login_process")
    public String login_process(Model model, HttpServletRequest request, HttpSession session) throws Exception {
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        // 계정 조회
        User user = userService.selectUserOne(new User(id, pass));

        if (user != null) {
            session.setAttribute("user", user); // Account 객체 전체를 세션에 저장
            log.info("로그인 성공");
            return "redirect:/";
        } else {
            model.addAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            log.info("로그인 실패");
            return "/user/login";
        }
    }


    // 내 정보 수정
    @PostMapping("/info_process")
    public String info_process(User user, HttpServletRequest request) throws Exception {
        // 정보 수정
        userService.updateUser(user);

        // 세션에 객체 저장
        HttpSession session = request.getSession();
        session.setAttribute("user", user); // Account 객체 전체를 세션에 저장

        log.info("내 정보 수정");
        return "redirect:/";
    }

    // 회원가입
    @PostMapping("/registerProcess")
    public ResponseEntity<String> register_process(User user) throws Exception {
        // 회원 가입 처리
        userService.insertUser(user);
        accountService.insertAccount(user.getId());

        log.info("회원 가입 성공");

        // 회원가입 성공 후 성공 메시지를 응답으로 전송
        return ResponseEntity.ok("회원 가입 성공");
    }

}
