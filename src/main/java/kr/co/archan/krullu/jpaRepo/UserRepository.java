package kr.co.archan.krullu.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.archan.krullu.entity.userEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<userEntity, Long> {

    Optional<userEntity> findByUsername(String username);

}
