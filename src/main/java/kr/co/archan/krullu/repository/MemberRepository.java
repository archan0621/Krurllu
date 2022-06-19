package kr.co.archan.krullu.repository;

import kr.co.archan.krullu.entity.MemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberEntity, Long>{

    MemberEntity findByUsername (String username);

}
