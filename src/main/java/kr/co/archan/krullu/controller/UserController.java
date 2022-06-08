package kr.co.archan.krullu.controller;

import kr.co.archan.krullu.jpaRepo.TestRepository;
import kr.co.archan.krullu.entity.testEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final TestRepository testRepository;

    @GetMapping("/dbcon")
    public List<testEntity> dbTest(){
        return testRepository.findAll();
    }

    @GetMapping("/connection")
    public String conTest(){
        return("pong!");
    }

}
