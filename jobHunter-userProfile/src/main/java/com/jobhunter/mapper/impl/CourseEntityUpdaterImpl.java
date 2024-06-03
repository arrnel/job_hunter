package com.jobhunter.mapper.impl;

import com.jobhunter.helper.CollectionHelper;
import com.jobhunter.helper.StringHelper;
import com.jobhunter.mapper.UserProfileUpdater;
import com.jobhunter.model.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileUpdaterImpl implements UserProfileUpdater {

    @Override
    public UserProfile update(UserProfile oldUserProfile, UserProfile newUserProfile) {

        return oldUserProfile.setEmail(
                        StringHelper.isNullOrBlank(newUserProfile.getEmail())
                                ? oldUserProfile.getEmail()
                                : newUserProfile.getEmail()
                )
                .setFirstName(
                        StringHelper.isNullOrBlank(newUserProfile.getFirstName())
                                ? oldUserProfile.getFirstName()
                                : newUserProfile.getFirstName()
                )
                .setLastName(
                        StringHelper.isNullOrBlank(newUserProfile.getLastName())
                                ? oldUserProfile.getLastName()
                                : newUserProfile.getLastName()
                )
                .setPosition(
                        StringHelper.isNullOrBlank(newUserProfile.getLastName())
                                ? oldUserProfile.getLastName()
                                : newUserProfile.getLastName()
                )
                .setDescription(
                        StringHelper.isNullOrBlank(newUserProfile.getLastName())
                                ? oldUserProfile.getLastName()
                                : newUserProfile.getLastName()
                )
                .setBirthDate(
                        newUserProfile.getBirthDate() == null
                                ? oldUserProfile.getBirthDate()
                                : newUserProfile.getBirthDate()
                )
                .setIsBirthDateVisible(
                        newUserProfile.getIsBirthDateVisible() == null
                                ? oldUserProfile.getIsBirthDateVisible()
                                : newUserProfile.getIsBirthDateVisible()
                )
                .setCityId(
                        newUserProfile.getCityId() == null || newUserProfile.getCityId() <= 0
                                ? oldUserProfile.getCityId()
                                : newUserProfile.getCityId()
                )
                .setAvatarId(
                        newUserProfile.getAvatarId() == null || newUserProfile.getAvatarId() <= 0
                                ? oldUserProfile.getAvatarId()
                                : newUserProfile.getAvatarId()
                )
                .setStatus(
                        newUserProfile.getStatus() == null
                                ? oldUserProfile.getStatus()
                                : newUserProfile.getStatus()
                )
                .setExperiences(
                        CollectionHelper.isNullOrEmpty(newUserProfile.getExperiences())
                                ? oldUserProfile.getExperiences()
                                : newUserProfile.getExperiences()
                )
                .setDateCreated(oldUserProfile.getDateCreated());

    }
}
