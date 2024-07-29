package com.mamivo.review.review.service.impl;

import com.mamivo.review.review.entity.Review;
import com.mamivo.review.review.exception.ResourceNotFoundException;
import com.mamivo.review.review.repository.ReviewRepository;
import com.mamivo.review.review.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IReviewServiceImpl implements IReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Override
	public Review findById(String id) {
		return reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Review.class.getSimpleName(), "id", id));
	}

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

	@Override
	public void create(Review review) {
		reviewRepository.save(review);
	}

	@Override
	public void deleteById(String id) {
		reviewRepository.deleteById(id);
	}

	@Override
	public void update(String id, Review review) {
		Review existingReview = reviewRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(Review.class.getSimpleName(), "id", id));
		// TODO: Create a mapper class.
		existingReview.setRate(review.getRate());
		existingReview.setBody(review.getBody());
		existingReview.setMovieId(review.getMovieId());

		reviewRepository.save(existingReview);
	}
}
