package ksy.shop.member.domain;

import lombok.*;

@Getter@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private Long num;
    private String name;
    private String id;
    private String password;

    public static MemberDTO toDTO(MemberEntity memberEntity) {
        return new MemberDTO(memberEntity.getNum(), memberEntity.getName(), memberEntity.getId(), memberEntity.getPassword());
    }
    public static MemberEntity toEntity(MemberDTO memberDTO) {
        return new MemberEntity(memberDTO.getNum(), memberDTO.getName(), memberDTO.getId(), memberDTO.getPassword());
    }
}
