package com.lifeistech.android.medicheck;

/**
 * Created by koizumikarin on 2018/03/28.
 */

import java.util.Calendar;
import io.realm.RealmObject;

public class Medicine extends RealmObject{


    int id;
    String name;
    String dose;
    int takePerDay;
    int timing;
    int days;
    String createdAt;
    int resId;

    public int getId(){return id;}
    public void setId(int id) { this.id = id; }

    public String getName(){return name;}
    public void setName(String name) { this.name = name ;}

    public String getDose(){return dose;}
    public void setDose(String dose) { this.dose = dose; }

    public int getTakePerDay() { return takePerDay; }
    public void setTakePerDay(int takePerDay) { this.takePerDay = takePerDay; }

    public int getTiming() { return timing; }
    public void setTiming(int timing) { this.timing = timing; }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public int getResId() { return resId; }
    public void setResId(int resId) { this.resId = resId; }
}