package me.yejinkim.springboot.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "newsletters")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    private LocalDate date;

    @Builder
    public Newsletter(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
