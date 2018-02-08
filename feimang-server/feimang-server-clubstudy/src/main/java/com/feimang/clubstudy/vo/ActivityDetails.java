package com.feimang.clubstudy.vo;

import com.feimang.clubstudy.pojo.Activity;
import com.feimang.clubstudy.pojo.ActivityBooks;

import java.util.List;

public class ActivityDetails {
    private Activity activity;

    private List<ActivityBooks> activityBooks;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<ActivityBooks> getActivityBooks() {
        return activityBooks;
    }

    public void setActivityBooks(List<ActivityBooks> activityBooks) {
        this.activityBooks = activityBooks;
    }
}
