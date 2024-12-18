package Jar;

import Jar.com.mysite.sbb.Answer;
import Jar.com.mysite.sbb.AnswerRepository;
import Jar.com.mysite.sbb.Question;
import Jar.com.mysite.sbb.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	public void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);
		//어떤 질문의 답변인지 알기 위해서 Question객체가 필요하다.
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);

	}


}
