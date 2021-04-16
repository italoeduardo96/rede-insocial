package com.br.redeinsocial.repository;

import com.br.redeinsocial.model.Post;
import com.br.redeinsocial.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	Page<Post> findAllByUser_UserIdOrderByDtCreateDesc(Long userId, Pageable pageable);
	
}
