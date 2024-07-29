package com.mamivo.review.review.controller;

import com.mamivo.review.review.dto.ResponseDto;
import com.mamivo.review.review.entity.Review;
import com.mamivo.review.review.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping(path = "/api/reviews", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ReviewController {

	@Autowired
	IReviewService iReviewService;

	@PostMapping
	public ResponseEntity<ResponseDto> create(@RequestBody Review review) {
		iReviewService.create(review);
		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED.toString(), "Review create successfully."));
	}

	@GetMapping
	public ResponseEntity<List<Review>> findAll() {
		return ResponseEntity.ok().body(iReviewService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Review> findById(@PathVariable String id) {
		Review review = iReviewService.findById(id);
		return ResponseEntity.ok().body(review);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseDto> delete(@PathVariable String id) {
		iReviewService.deleteById(id);
		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED.toString(), "Review deleted successfully."));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseDto> update(@PathVariable String id, @RequestBody Review review) {
		iReviewService.update(id, review);
		return ResponseEntity.ok().body(new ResponseDto(HttpStatus.CREATED.toString(), "Review updated successfully."));
	}
}
