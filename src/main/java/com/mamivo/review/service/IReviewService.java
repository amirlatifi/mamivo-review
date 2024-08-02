package com.mamivo.review.service;

import com.mamivo.review.entity.Review;

import java.util.List;

public interface IReviewService {
	Review findById(String id);
	List<Review> findAll();
	void create(Review review);
	void deleteById(String reviewId);
	void update(String id, Review review);
}