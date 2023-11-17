package com.example.CProject.entity;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "page_info")
@Data
public class PageInfo {

    @Id
    private String id;

    private int randnum;
    private String image;
    private String color;
    private String place;
    private String people;
    private String time;

    // 생성자, getter, setter 등의 메서드는 Lombok이 자동으로 생성
}