package com.springbook.biz.reply;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;




public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	   @Query("SELECT r FROM Reply r WHERE r.boardNo =:boardNo order by r.userReplyNo desc")
	   ArrayList<Reply> ReplylistDesc(@Param("boardNo")Integer boardNo);
	   
   
}
