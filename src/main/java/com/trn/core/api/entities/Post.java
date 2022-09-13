package com.trn.core.api.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @Column(name="post_title", length = 100, nullable = false)
    private String title;

    @Column(length = 10000)
    private  String content;

    private  String imageName;

    private Date addedDate;

}
