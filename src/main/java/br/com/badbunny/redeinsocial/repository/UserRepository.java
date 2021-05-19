package br.com.badbunny.redeinsocial.repository;

import br.com.badbunny.redeinsocial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByNicknameLikeIgnoreCase(String nickname);

}
