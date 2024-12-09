package com.example.new_project.controller;

import com.example.new_project.entity.Account;
import com.example.new_project.entity.Notice;
import com.example.new_project.entity.User;
import com.example.new_project.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

// 게시판 관련
@Controller
@Log4j2 // 로그
@RequestMapping("/notice") // 앞에 붙이는거 security 쓸때 편함
@RequiredArgsConstructor // @Autowired 대신
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(page = 0, size = 5) Pageable pageable) throws Exception {
        List<Notice> list = noticeService.selectNoticeList();

        // 페이지 정보에 따라 현재 페이지의 시작 인덱스를 계산
        final int start = (int) pageable.getOffset();
        // 현재 페이지의 끝 인덱스를 계산하되, 목록 크기를 초과하지 않도록 함
        final int end = Math.min((start + pageable.getPageSize()), list.size());
        // 현재 페이지의 아이템 서브리스트를 포함하는 Page 객체 생성
        log.info("start: {}, end: {}", start, end);
        final Page<Notice> page = new PageImpl<>(list.subList(start, end), pageable, list.size());
        log.info("총 페이지 수 : {}", page.getTotalPages());
        log.info("전체 개수 : {}", page.getTotalElements());
        log.info("현재 페이지 번호 : {}", page.getNumber());
        log.info("페이지당 데이터 개수 : {}", page.getSize());
        log.info("다음 페이지 존재 여부 : {}", page.hasNext());
        log.info("이전 페이지 존재 여부 : {}", page.hasPrevious());
        log.info("시작페이지(0) 입니까 : {}", page.isFirst());
        model.addAttribute("list", page);
        log.info("자료실, 공지");
        return "notice/noticeList";
    }

    @GetMapping("/openNoticeWrite")
    public String openNoticeWrite() {
        log.info("자료실 글쓰기");
        return "notice/noticeWrite";
    }

    @GetMapping("/openNoticeDetail")
    public String openNoticeDetail(@RequestParam int notice_num, Model model) throws Exception {
        Notice notice = noticeService.selectNoticeDetail(notice_num);
        model.addAttribute("notice", notice);
        log.info("자료실 상세 페이지");
        return "notice/noticeDetail";
    }

    @PostMapping("/updateNotice")
    public String updateNotice(Notice notice) throws Exception {
        noticeService.updateNotice(notice);
        log.info("자료실 글 수정");
        return "redirect:/notice/list";
    }

    @PostMapping("/deleteNotice")
    public String deleteNotice(int notice_num) throws Exception {
        noticeService.deleteNotice(notice_num);
        log.info("자료실 글 삭제");
        return "redirect:/notice/list";
    }

    @PostMapping("/insertNotice")
    public String insertNotice(HttpServletRequest request, HttpSession session) throws Exception {
        // 세션에서 사용자 정보 가져오기
        User user = (User) session.getAttribute("user");
        String id = null;
        String name = null;
        if (user != null) {
            id = user.getId();
            name = user.getName();
            // id를 사용하여 필요한 작업 수행
        }
        String title = (String) request.getParameter("title");
        String content = (String) request.getParameter("contents");

        // 세션에서 정보가 없으면 로그인 페이지로 리다이렉트
        if (id == null || name == null) {
            return "redirect:/user/login"; // 로그인 페이지 경로로 수정
        }

        Notice notice = new Notice(title, content);

        // 게시글 정보 저장
        noticeService.insertNotice(notice);
        log.info("게시글 저장");

        return "redirect:/notice/list";
    }
}
