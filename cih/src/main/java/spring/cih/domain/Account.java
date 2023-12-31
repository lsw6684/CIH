package spring.cih.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") // 순환 참조로 Stack overflow 방지
@Builder @AllArgsConstructor @NoArgsConstructor
public class Account {

    @Id    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String nickName;

    private String password;

    private boolean emailVerified;

    private String emailCheckToken;

    private LocalDateTime joinedAt;

    private String bio;

    private String url;

    private String occupation;

    private String location; // varchar

    @Lob @Basic(fetch = FetchType.EAGER)// 255보다 높으면 Text로 전환
    private String profileImage;

    private boolean createdByEmail;

    private boolean createdByWeb;

    private boolean enrollmentResultByEmail;

    private boolean enrollmentResultByWeb;

    private boolean updateByEmail;
    private boolean updateByWeb;



}
