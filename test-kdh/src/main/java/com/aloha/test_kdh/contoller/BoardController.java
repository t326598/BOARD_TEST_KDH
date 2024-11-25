package com.aloha.test_kdh.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aloha.test_kdh.domain.Board;
import com.aloha.test_kdh.domain.Page;
import com.aloha.test_kdh.service.BoardService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

@Autowired
private BoardService boardService;

// 게시판 목록

@GetMapping("/list")
public String list(Model model, Page page) throws Exception {
    
    List<Board> boardList = boardService.list(page);
    
    model.addAttribute("boardList", boardList);
    model.addAttribute("rows", page.getRows());
    model.addAttribute("page", page);
    
    return "board/list";
}

// 게시글 등록 이동
@GetMapping("/insert")
public String insert() {
    return "/board/insert";
}

// 게시글 등록 처리
@PostMapping("/insert")
public String insert(Model model, Board board) throws Exception {
    int result = boardService.insert(board);

    if (result > 0) {
        log.info("등록 성공");        
        return "redirect:/board/list";
    }
    log.info("등록 실패");
    return "/board/insert?error";
}

// 게시글 조회
@GetMapping("/select")
public String select(Model model, @RequestParam("no") int no) throws Exception {
    Board board = boardService.select(no);
    model.addAttribute("board", board);

    return "/board/select";
}

// 게시글 삭제
@PostMapping("/delete")
public String delete(@RequestParam("no") int no) throws Exception{
    int result = boardService.delete(no);
    
    if (result > 0) {
        log.info("삭제 성공");
        return "redirect:/board/list";
        
    }
    log.info("삭제 실패");
    return "redirect:/board/update?error&no="+ no;
}

@GetMapping("/update")
public String update(Model model, @RequestParam("no") int no) throws Exception {
    Board board = boardService.select(no);
    model.addAttribute("board", board);
    return "board/update";
}

@PostMapping("/update")
public String update(Board board) throws Exception {
    int result = boardService.update(board);
    
    if (result > 0) {
        log.info("업데이트 성공");
        
        return "redirect:/board/list";
    }
    log.info("수정 실패");
    return "redirect:/board/update?error&no="+ board.getNo();

    
}


}
