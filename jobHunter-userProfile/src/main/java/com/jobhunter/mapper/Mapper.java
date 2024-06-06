package com.jobhunter.mapper;

public interface Mapper<D, S> {
    D map(S source);
}
