package Jar.com.mysite.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
//반복되는 프리픽스는 @RequestMapping()을 통해 괄호안에 선언하여 후에 맵핑에서 생략할 수 있다.
@RequiredArgsConstructor
//Lombok이넹?
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    //@RequestMapping("/question") 을 클래스 위에 선언함으로써 해당 에노테이션은
    //@GetMapping("/question/list") 와 같다.
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    //@RequestMapping("/question") 을 클래스 위에 선언함으로써 해당 에노테이션은
    //@GetMapping("/question/detail/{id}") 와 같다.
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(Model model) {
        model.addAttribute("questionForm", new QuestionForm());
        return "question_form";
    }

    @PostMapping(value = "/create")
    public String questionCreate(@Valid @ModelAttribute QuestionForm questionForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("questionForm", questionForm);
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
