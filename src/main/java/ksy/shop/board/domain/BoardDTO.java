package ksy.shop.board.domain;

import ksy.shop.member.domain.MemberDTO;
import lombok.*;

@Getter@Setter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long num;
    private String title;
    private String content;
    private String reg_date;

    private MemberDTO member;

    public static BoardDTO toDTO(BoardEntity boardEntity) {
        return new BoardDTO(boardEntity.getNum(), boardEntity.getTitle(), boardEntity.getContent(), boardEntity.getReg_date(), MemberDTO.toDTO(boardEntity.getMember()));
    }
    public static BoardEntity toEntity(BoardDTO boardDTO) {
        return new BoardEntity(boardDTO.getNum(), boardDTO.getTitle(), boardDTO.getContent(), boardDTO.getReg_date(), MemberDTO.toEntity(boardDTO.getMember()));
    }
}
