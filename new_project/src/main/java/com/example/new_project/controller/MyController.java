package com.example.new_project.controller;

import com.example.new_project.entity.Frequently_Question;
import com.example.new_project.service.FAQService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:9999")
@RequiredArgsConstructor
public class MyController {

    private final FAQService faqService;

    @GetMapping("/")
    public String index() {
        return "/main";
    }

    @GetMapping("/map")
    public String map(){
        return "/map";
    }

    @GetMapping("/faq")
    public String faq(Model model) throws Exception {
        List<Frequently_Question> faq = faqService.selectAllFAQ();
        model.addAttribute("faq", faq);
        return "/faq/faqList";
    }
}
