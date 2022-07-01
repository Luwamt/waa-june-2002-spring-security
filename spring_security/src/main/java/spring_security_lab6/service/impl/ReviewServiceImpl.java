package spring_security_lab6.service.impl;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring_security_lab6.dto.ReviewDto;
import spring_security_lab6.entity.Review;
import spring_security_lab6.repository.ReviewRepository;
import spring_security_lab6.service.ReviewService;

import java.lang.reflect.Type;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    private ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper modelMapper){
        this.reviewRepository = reviewRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReviewDto> findAll() {
        var reviews = reviewRepository.findAll();
        Type listType = new TypeToken<List<ReviewDto>>(){}.getType();
        return modelMapper.map(reviews,listType);
    }

    @Override
    @Transactional(readOnly = true)
    public ReviewDto findById(Long id) {
        var review = reviewRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Review with id %s does not exits",id)));
        return modelMapper.map(review, ReviewDto.class);
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        var review = modelMapper.map(reviewDto, Review.class);
        return modelMapper.map(reviewRepository.save(review), ReviewDto.class);
    }

    @Override
    public List<ReviewDto> findAllReviewByProductId(Long id) {
        var reviews = reviewRepository.findAllByProductId(id);
        Type listType = new TypeToken<List<ReviewDto>>(){}.getType();
        return modelMapper.map(reviews,listType);
    }
}
