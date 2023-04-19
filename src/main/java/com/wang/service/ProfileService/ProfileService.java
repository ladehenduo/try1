package com.wang.service.ProfileService;

import com.wang.pojo.Profile;

public interface ProfileService {
    public Profile getProfileByUser(String username);
    public Profile getProfileByID(String IDcard);
    public boolean addProfile(Profile profile);
    public boolean deleteProfile(String username, String IDcard);
    public boolean updateProfile(Profile profile);
}
