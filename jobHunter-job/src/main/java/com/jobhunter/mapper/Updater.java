package com.jobhunter.mapper;

public interface Updater<S> {

    S update(S oldValue, S newValue);

}
