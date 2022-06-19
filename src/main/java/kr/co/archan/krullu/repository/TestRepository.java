package kr.co.archan.krullu.repository;

import kr.co.archan.krullu.entity.testEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<testEntity, Long> {

}
