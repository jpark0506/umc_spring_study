package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Missions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String missionTitle;

    @Column(nullable = false, length = 20)
    private String missionContent;

    @Column(nullable = false)
    private LocalDate missionExpireDate;

    @Column(nullable = false)
    private LocalDate missionReward;

    private String mission_store_id;
}
