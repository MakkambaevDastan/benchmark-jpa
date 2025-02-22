package kg.nurtelecom.benchmark.service;

public interface BenchmarkService {

    String benchmark(String repository, int size, int count);

    String benchmark(String repository, int size);

    String clear();
}
