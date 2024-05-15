package com.jobhunter.mapper.impl;

import com.jobhunter.helper.CollectionHelper;
import com.jobhunter.mapper.JobUpdater;
import com.jobhunter.model.Job;
import org.springframework.stereotype.Component;

import static com.jobhunter.helper.NumbersHelper.isNullOrZero;
import static com.jobhunter.helper.StringHelper.isEmptyOrBlank;

@Component
public class JobToJobUpdaterImpl implements JobUpdater {

    @Override
    public Job update(Job oldJob, Job newJob) {

        return oldJob
                .setTitle((isEmptyOrBlank(newJob.getTitle()) ? oldJob.getTitle() : newJob.getTitle()))
                .setDescription((isEmptyOrBlank(newJob.getDescription()) ? oldJob.getDescription() : newJob.getDescription()))
                .setCompanyId(isNullOrZero(newJob.getCompanyId()) ? oldJob.getCompanyId() : newJob.getCompanyId())
                .setMinPrice(isNullOrZero(newJob.getMinPrice()) ? oldJob.getMinPrice() : newJob.getMinPrice())
                .setMinPriceInDefaultCurrency(isNullOrZero(newJob.getMinPriceInDefaultCurrency()) ? oldJob.getMinPriceInDefaultCurrency() : newJob.getMinPriceInDefaultCurrency())
                .setMaxPrice(isNullOrZero(newJob.getMaxPrice()) ? oldJob.getMaxPrice() : newJob.getMaxPrice())
                .setMaxPriceInDefaultCurrency(isNullOrZero(newJob.getMaxPriceInDefaultCurrency()) ? oldJob.getMaxPriceInDefaultCurrency() : newJob.getMaxPriceInDefaultCurrency())
                .setCurrency(newJob.getCurrency() == null ? oldJob.getCurrency() : newJob.getCurrency())
                .setJobTypes(CollectionHelper.isNullOrEmpty(newJob.getJobTypes()) ? oldJob.getJobTypes() : newJob.getJobTypes())
                .setSpecializationSubCategories(CollectionHelper.isNullOrEmpty(newJob.getSpecializationSubCategories()) ? oldJob.getSpecializationSubCategories() : newJob.getSpecializationSubCategories())
                .setIndustriesSubCategories(CollectionHelper.isNullOrEmpty(newJob.getIndustriesSubCategories()) ? oldJob.getIndustriesSubCategories() : newJob.getIndustriesSubCategories())
                .setCityId(isNullOrZero(newJob.getCityId()) ? oldJob.getCityId() : newJob.getCityId())
                .setRegionId(isNullOrZero(newJob.getRegionId()) ? oldJob.getRegionId() : newJob.getRegionId())
                .setCountryId(isNullOrZero(newJob.getCountryId()) ? oldJob.getCountryId() : newJob.getCountryId())
                .setDateCreated(newJob.getDateCreated() == null ? oldJob.getDateCreated() : newJob.getDateCreated())
                .setDateUpdated(newJob.getDateUpdated() == null ? oldJob.getDateUpdated() : newJob.getDateUpdated());

    }
}
