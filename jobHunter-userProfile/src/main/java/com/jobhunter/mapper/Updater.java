package com.jobhunter.mapper;

public interface Updater<S> {
    S update(S oldSource, S newSource);
}
