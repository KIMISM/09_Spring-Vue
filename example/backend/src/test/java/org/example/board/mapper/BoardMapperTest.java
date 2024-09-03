package org.example.board.mapper;


import org.example.board.domain.BoardVO;
import org.example.config.RootConfig;
import org.example.security.config.SecurityConfig;
import lombok.extern.log4j.Log4j;
import org.example.board.domain.BoardVO;
import org.example.board.mapper.BoardMapper;
import org.example.config.RootConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { RootConfig.class, SecurityConfig.class })
@Log4j
public class BoardMapperTest {
    @Autowired
    BoardMapper mapper;

    @Test
    void testPaging(){
        for(int i=1;i<=110;i++){
            BoardVO board = BoardVO.builder()
                    .title("페이징 테스트 "+i)
                    .writer("user0")
                    .content("페이징 테스트 "+i)
                    .build();
            mapper.create(board);
        }
    }
}