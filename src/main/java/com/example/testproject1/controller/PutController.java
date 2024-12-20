package com.example.testproject1.controller;

import com.example.testproject1.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")

public class PutController {

    //http://localhost:8080/api/v1/put-api/default
    @PutMapping(value = "/default")
    public String putMethod() {return "Hello World!";}

    //http://localhost:8080/api/v1/put-api/member
    @PutMapping(value ="/member")
    public String postMember(@RequestBody Map<String,Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() +"\n");
        });
        return sb.toString();
        }

    //http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value="/member1")
    public String postMember1(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
    //http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value="/member2")
    public MemberDTO postMember2(@RequestBody MemberDTO memberDTO) {
        return memberDTO;
    }
    //http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value="/member3")
    public ResponseEntity<MemberDTO> postMember3(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}
