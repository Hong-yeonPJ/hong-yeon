package com.hy.hongyeon.event.dto;

import com.hy.hongyeon.event.entity.EventCategory;
import com.hy.hongyeon.event.entity.EventStatus;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
public class EventDto {
    @NotEmpty(message = "제목은 필수항목입니다.")
    private String title;

    @NotNull(message = "헤더 이미지는 필수항목입니다.")
    private MultipartFile header;

    @NotNull(message = "상세설명 이미지는 필수항목입니다.")
    private MultipartFile detail;

    @NotEmpty(message = "장소는 필수항목입니다.")
    private String location;

    private LocalDate date;

    private EventCategory eventCategory;

    @NotNull(message = "좌석수는 필수항목입니다.")
    @Min(value = 0, message = "좌석은 0석 이상이어야 합니다.")
    private int seatCapacity;

    @NotNull(message = "입장료는 필수항목입니다.")
    @Min(value = 0, message = "가격은 0 이상이어야 합니다.")
    private int entranceFee;

    private EventStatus eventStatus;

    //@NotNull(message = "예매 오픈 일시는 필수항목입니다.")
    //private LocalDateTime eventOpenDate;
}