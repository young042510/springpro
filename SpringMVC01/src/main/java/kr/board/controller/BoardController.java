package kr.board.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {

	// boardList.do
	@Autowired
	private BoardMapper mapper;
	// HandlerMapping
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		List<Board> list = mapper.getLists();
		model.addAttribute("list", list);

		return "boardList"; // /WEB-INF/Views/ ->viewresolver->forward
	}
	//boardForm.do
	@GetMapping("/boardForm.do")
	public String boardForm() {
		return "boardForm"; // / WEB_INF/Views/boardForm.jsp ->forward
	}
	@PostMapping("/boardInsert.do")
	public String boardInsert(Board vo) { //파라미터수집(board) title, content, writer
		mapper.boardInsert(vo);
		return "redirect:/boardList.do";
	}
	@GetMapping("/boardContent.do")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo); // ${vo.idx}...
		return "boardContent";
	}
	@GetMapping("/boardDelete.do/{idx}")
	public String boardDelete(@PathVariable("idx") int idx) {
		mapper.boardDelete(idx);
		return "redirect:/boardList.do";
	}
}
