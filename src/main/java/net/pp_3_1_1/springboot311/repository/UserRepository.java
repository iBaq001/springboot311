package net.pp_3_1_1.springboot311.repository;

import net.pp_3_1_1.springboot311.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
