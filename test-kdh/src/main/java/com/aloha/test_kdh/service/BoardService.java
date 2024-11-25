package com.aloha.test_kdh.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aloha.test_kdh.domain.Board;
import com.aloha.test_kdh.domain.Page;

public interface BoardService {
    
    public List<Board> list() throws Exception;
     public List<Board> list(@Param("page") Page page) throws Exception;
    
    
    public Board select(@Param("no") int no) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;
    
    public int delete(@Param("no") int no) throws Exception;
    
}

