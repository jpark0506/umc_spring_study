package umc.study.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.Missions;
import umc.study.domain.Users;
import umc.study.domain.Terms;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMissionStatus extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Missions mission;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'STARTED'")
    private MissionStatus status;

    private LocalDateTime missionStartTime;

    private LocalDateTime missionFinishedTime;

    private LocalDateTime missionApprovedTime;


}
