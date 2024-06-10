package com.jobhunter.mapper.impl;

import com.jobhunter.helper.CollectionHelper;
import com.jobhunter.helper.StringHelper;
import com.jobhunter.mapper.UserProfileUpdater;
import com.jobhunter.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileUpdaterImpl implements UserProfileUpdater {

    @Override
    public UserProfile update(UserProfile oldSource, UserProfile newSource) {

        return oldSource.setEmail(
                        StringHelper.isNullOrBlank(newSource.getEmail())
                                ? oldSource.getEmail()
                                : newSource.getEmail()
                )
                .setFirstName(
                        StringHelper.isNullOrBlank(newSource.getFirstName())
                                ? oldSource.getFirstName()
                                : newSource.getFirstName()
                )
                .setLastName(
                        StringHelper.isNullOrBlank(newSource.getLastName())
                                ? oldSource.getLastName()
                                : newSource.getLastName()
                )
                .setPosition(
                        StringHelper.isNullOrBlank(newSource.getLastName())
                                ? oldSource.getLastName()
                                : newSource.getLastName()
                )
                .setDescription(
                        StringHelper.isNullOrBlank(newSource.getLastName())
                                ? oldSource.getLastName()
                                : newSource.getLastName()
                )
                .setBirthDate(
                        newSource.getBirthDate() == null
                                ? oldSource.getBirthDate()
                                : newSource.getBirthDate()
                )
                .setIsBirthDateVisible(
                        newSource.getIsBirthDateVisible() == null
                                ? oldSource.getIsBirthDateVisible()
                                : newSource.getIsBirthDateVisible()
                )
                .setCityId(
                        newSource.getCityId() == null || newSource.getCityId() <= 0
                                ? oldSource.getCityId()
                                : newSource.getCityId()
                )
                .setAvatarId(
                        newSource.getAvatarId() == null || newSource.getAvatarId() <= 0
                                ? oldSource.getAvatarId()
                                : newSource.getAvatarId()
                )
                .setStatus(
                        newSource.getStatus() == null
                                ? oldSource.getStatus()
                                : newSource.getStatus()
                )
//                .setExperiences(
//                        CollectionHelper.isNullOrEmpty(newSource.getExperiences())
//                                ? oldSource.getExperiences()
//                                : newSource.getExperiences()
//                )
//                .setCourses(
//                        CollectionHelper.isNullOrEmpty(newSource.getCourses())
//                                ? oldSource.getCourses()
//                                : newSource.getCourses()
//                )
//                .setEducations(
//                        CollectionHelper.isNullOrEmpty(newSource.getEducations())
//                                ? oldSource.getEducations()
//                                : newSource.getEducations()
//                )
                ;

    }
}
