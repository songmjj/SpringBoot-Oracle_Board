package com.springbook.biz.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BoardRepository extends JpaRepository<Board, Integer> {

   @Query("SELECT b FROM Board b where b.grade='USER' order by b.boardNo desc")
   ArrayList<Board> boardlistDesc();
   
   @Query("SELECT b FROM Board b where b.grade='ADMIN' order by b.boardNo desc")
   ArrayList<Board> boardlistDesc_n();
   
}
