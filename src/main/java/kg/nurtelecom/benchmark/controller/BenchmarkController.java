package kg.nurtelecom.benchmark.controller;

import kg.nurtelecom.benchmark.service.BenchmarkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/benchmark")
public class BenchmarkController {
    private final BenchmarkService service;

    public BenchmarkController(BenchmarkService service) {
        this.service = service;
    }

    @PostMapping("/{repository}/{size}/{count}")
    public ResponseEntity<String> benchmark(
            @PathVariable("repository") String repository,
            @PathVariable("size") int size,
            @PathVariable(value = "count") int count
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.benchmark(repository, size, count));
    }

    @PostMapping("/{repository}/{size}")
    public ResponseEntity<String> benchmark(
            @PathVariable("repository") String repository,
            @PathVariable("size") int size
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.benchmark(repository, size));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.clear());
    }
}
