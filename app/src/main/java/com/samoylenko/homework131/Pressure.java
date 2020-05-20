package com.samoylenko.homework131;

import java.sql.Time;
import java.util.Date;

public class Pressure {
    private User user;
    private int lowPres;
    private int highPres;
    private int pulse;
    private String tachycard;
    private Date nowDate;
    private Time nowTime;

    public Pressure() {
    }

    public Pressure(User user, int lowPres, int highPres, int pulse, String tachycard, Date nowDate, Time nowTime) {
        this.user = user;
        this.lowPres = lowPres;
        this.highPres = highPres;
        this.pulse = pulse;
        this.tachycard = tachycard;
        this.nowDate = nowDate;
        this.nowTime = nowTime;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Pressure{" +
                "user=" + user +
                ", lowPres=" + lowPres +
                ", highPres=" + highPres +
                ", pulse=" + pulse +
                ", tachycard='" + tachycard + '\'' +
                ", nowDate=" + nowDate +
                ", nowTime=" + nowTime +
                '}';
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLowPres() {
        return lowPres;
    }

    public void setLowPres(int lowPres) {
        this.lowPres = lowPres;
    }

    public int getHighPres() {
        return highPres;
    }

    public void setHighPres(int highPres) {
        this.highPres = highPres;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public String getTachycard() {
        return tachycard;
    }

    public void setTachycard(String tachycard) {
        this.tachycard = tachycard;
    }

    public Date getNowDate() {
        return nowDate;
    }

    public void setNowDate(Date nowDate) {
        this.nowDate = nowDate;
    }

    public Time getNowTime() {
        return nowTime;
    }

    public void setNowTime(Time nowTime) {
        this.nowTime = nowTime;
    }


}
