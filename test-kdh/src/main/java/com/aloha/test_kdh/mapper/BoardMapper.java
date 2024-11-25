package com.aloha.test_kdh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.aloha.test_kdh.domain.Board;
import com.aloha.test_kdh.domain.Page;

@Mapper
public interface BoardMapper {

    public List<Board> list(@Param("page") Page page) throws Exception;
    
    public Board select(@Param("no") int no) throws Exception;

    public int insert(Board board) throws Exception;

    public int update(Board board) throws Exception;
    
    public int delete(@Param("no") int no) throws Exception;
    
    public List<Board> list();

    public int count()throws Exception;
}
