package org.example.member.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.common.util.UploadFiles;
import org.example.member.dto.MemberDTO;
import org.example.member.dto.MemberJoinDTO;
import org.example.member.dto.MemberUpdateDTO;
import org.example.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Slf4j
@RestController //json과 관련?
@RequiredArgsConstructor
@RequestMapping("/api/member") //공통 url
public class MemberController {
    final MemberService service;

//    @PathVariable :  경로상에 username을 변수 처리(이름 일치해야함)
    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        //        주어진 사용자 이름의 중복 여부 체크하고 결과를 ResponseEntity로 반환
        return ResponseEntity.ok().body(service.checkDuplicate(username));
    }
    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member){
//회원 가입 처리하고 가입된 회원 정보를 ResponseEntity로 반환
        return ResponseEntity.ok(service.join(member));
    }
    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response){
        String avatarPath = "c:/Upload/avatar/" + username +".png"; // 이미지 경로 생성
        File file = new File(avatarPath);
//        아바타 이미지가 존재하지 않을 경우, 기본 아바타 이미지 사용
        if(!file.exists()){
            file = new File("C:/Upload/avatar/unknown.png");
        }
//        이미지 다운로드 처리
        UploadFiles.downloadImage(response,file);
    }
//    회원 프로필 변경 요청을 처리하는 메소드
    @PutMapping("/{username}")
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {
        return ResponseEntity.ok(service.update(member));
    }
}
