package com.example.Springboot_Start.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 baseTimeEntity 를 상속받을경우 필드들(createdDate,modifiedDate) 도 칼럼으로 인식한다.
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate; //Entity가 생성되어 저장될때 시간이 자동 저장된다.

    @LastModifiedDate
    private LocalDateTime modifiedDate;//조회한 Entity 의 값이 변경될때 시간이 자동저장된다.
}
