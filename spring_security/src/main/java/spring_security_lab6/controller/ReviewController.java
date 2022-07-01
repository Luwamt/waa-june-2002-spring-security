package spring_security_lab6.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring_security_lab6.dto.ReviewDto;
import spring_security_lab6.service.ReviewService;

import java.util.List;

@RestController
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAll(){
        var reviewDtos = reviewService.findAll();
        return ResponseEntity.ok().body(reviewDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getById(@PathVariable Long id){
        var reviewDto = reviewService.findById(id);
        return ResponseEntity.ok(reviewDto);
    }

    @PostMapping
    public ResponseEntity<ReviewDto> create(@RequestBody ReviewDto reviewDto){
        reviewDto = reviewService.save(reviewDto);
        return ResponseEntity.ok(reviewDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> update(@RequestBody ReviewDto reviewDto, @PathVariable Long id){
        reviewDto.setId(id);
        reviewDto = reviewService.save(reviewDto);
        return ResponseEntity.ok(reviewDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reviewService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
