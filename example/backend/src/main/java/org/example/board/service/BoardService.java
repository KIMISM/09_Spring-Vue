package org.example.board.service;

import org.example.board.domain.BoardAttachmentVO;
import org.example.board.dto.BoardDTO;
import org.example.common.pagination.Page;
import org.example.common.pagination.PageRequest;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    Page<BoardDTO> getPage(PageRequest pageRequest);
    public List<BoardDTO> getList();

    public BoardDTO get(Long no);

    public BoardDTO create(BoardDTO board);

    public BoardDTO update(BoardDTO board);

    public BoardDTO delete(Long no);

    public BoardAttachmentVO getAttachment(Long no);

    public boolean deleteAttachment(Long no);
}
