package spring_security_lab6.service;



import spring_security_lab6.dto.ReviewDto;

import java.util.List;

public interface ReviewService {

    List<ReviewDto> findAll();
    ReviewDto findById(Long id);
    void delete(Long id);
    ReviewDto save(ReviewDto review);
    List<ReviewDto> findAllReviewByProductId(Long id);
}
