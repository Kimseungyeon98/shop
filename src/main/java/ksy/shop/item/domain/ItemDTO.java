package ksy.shop.item.domain;

import ksy.shop.member.domain.MemberDTO;
import lombok.*;

@Setter@Getter@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private Long num;
    private String name;
    private String type;
    private String content;
    private Long price;
    private String image;
    private String reg_date;
    private Long quantity;

    private MemberDTO member;

    public static ItemDTO toDTO(ItemEntity itemEntity) {
        return new ItemDTO(itemEntity.getNum(), itemEntity.getName(), itemEntity.getType(), itemEntity.getContent(), itemEntity.getPrice(), itemEntity.getImage(), itemEntity.getReg_date(), itemEntity.getQuantity(), MemberDTO.toDTO(itemEntity.getMember()));
    }
    public static ItemEntity toEntity(ItemDTO itemDTO) {
        return new ItemEntity(itemDTO.getNum(), itemDTO.getName(), itemDTO.getType(), itemDTO.getContent(), itemDTO.getPrice(), itemDTO.getImage(), itemDTO.getReg_date(), itemDTO.getQuantity(), MemberDTO.toEntity(itemDTO.getMember()));
    }
}
