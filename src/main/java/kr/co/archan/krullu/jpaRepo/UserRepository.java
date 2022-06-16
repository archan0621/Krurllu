package kr.co.archan.krullu.jpaRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.archan.krullu.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

}
