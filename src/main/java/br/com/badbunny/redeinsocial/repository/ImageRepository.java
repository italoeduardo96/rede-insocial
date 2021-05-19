package br.com.badbunny.redeinsocial.repository;


import br.com.badbunny.redeinsocial.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {

}
