package com.hy.hongyeon.event.entity;

import com.hy.hongyeon.global.image.entity.Image;
import com.hy.hongyeon.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Event {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long EventId;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private String title;

    @ManyToOne
    private Member writer;

    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    private int seatCapacity;

    private int entranceFee;

    private LocalDateTime eventOpenDate;

    private LocalDate eventDate;

    private String location;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Image header;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Image detail;
}