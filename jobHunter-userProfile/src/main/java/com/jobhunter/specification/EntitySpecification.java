package com.jobhunter.specification;

public interface EntitySpecification<D, S> {
    D findByCriteria(S source);
}
