package com.aloha.test_kdh.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Alias("Board")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

    private int no;
    private String title;
    private String writer;
    private String content;
    private Date createdAt;
    private Date updatedAt;

    

}
