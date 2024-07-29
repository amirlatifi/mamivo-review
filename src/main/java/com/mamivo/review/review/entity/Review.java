package com.mamivo.review.review.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	@Id
	private String id;
	private Long movieId;
	private String body;
	private int rate;
	@Version
	private Long version;
}
