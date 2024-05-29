package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.UserFoodPreferences;
import umc.study.domain.mapping.UserMissionStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@DynamicInsert
@DynamicUpdate
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Users extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Column(nullable = true)
    private LocalDate birthdate;

    @Column(nullable = false, length = 80)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private UserStatus status;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = true)
    private LocalDate inactiveDate;

    @Column(nullable = false)
    @ColumnDefault("0")
    private Integer Point;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserFoodPreferences> userFoodPreferences = new ArrayList<>();
}