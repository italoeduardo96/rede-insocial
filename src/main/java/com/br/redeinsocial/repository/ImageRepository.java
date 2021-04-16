package com.br.redeinsocial.repository;


import com.br.redeinsocial.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {

}
