package kr.co.archan.krullu.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="chk")
public class testEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @Column(nullable = false, length = 100)
    private Integer test;

    public testEntity(Integer test){
        this.test = test;
    }
}
