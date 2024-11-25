package com.aloha.test_kdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aloha.test_kdh.domain.Board;
import com.aloha.test_kdh.domain.Page;
import com.aloha.test_kdh.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImple implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<Board> list() throws Exception {

        List<Board> boardList = boardMapper.list(new Page());

        return boardList;
    }

    @Override
    public Board select(int no) throws Exception {
        Board board = boardMapper.select(no);

        return board;
    }

    @Override
    public int insert(Board board) throws Exception {
        int result = boardMapper.insert(board);

            return result;
    }

    @Override
    public int update(Board board) throws Exception {
        int result = boardMapper.update(board);

        return result;
    }

    @Override
    public int delete(int no) throws Exception {
        int result = boardMapper.delete(no);

        return result;

    }

    @Override
    public List<Board> list(Page page) throws Exception {
        int total = boardMapper.count();
        page.setTotal(total);
        
        List<Board> boardList = boardMapper.list(page);
        return boardList;

    }


    
}
