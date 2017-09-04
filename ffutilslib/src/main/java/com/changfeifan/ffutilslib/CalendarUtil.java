package com.changfeifan.ffutilslib;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by changfeifan on 2016/11/8.
 */

public class CalendarUtil {

    public static String times(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14  16:09:00"）
     *
     * @param time
     * @return
     */
    public static final String timedate(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        return times;

    }

    /**
     * 调用此方法输入所要转换的时间戳输入例如（1402733340）输出（"2014-06-14  16:09:00"）
     *
     * @param time
     * @return
     */
    public static final Date timedates(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        @SuppressWarnings("unused")
        long lcc = Long.valueOf(time);
        int i = Integer.parseInt(time);
        String times = sdr.format(new Date(i * 1000L));
        try {
            Date date = sdr.parse(times);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();

    }

    /**
     * @param end   当前时间
     * @param start 目标时间
     */

    public static String getInterval(Date start, Date end) {
        long m = start.getTime() / 1000;
        if (m == 0) {
            return "";
        } else {
            long current = end.getTime() / 1000;
            long mm = current - m;
            if (LanguageUtil.checkLanguage()) {
                if (mm < 60) {
                    return "1 minute ago";
                } else if (mm > 60 && mm < 3600) {
                    return mm / 60 + "minutes ago";
                } else if (mm >= 3600 && mm < 3600 * 24) {
                    if ((float) (mm / 3600) > 2) {
                        return mm / 3600 + "hours ago";
                    } else
                        return mm / 3600 + "hour ago";
                } else {
                    if ((float) (mm / (3600 * 24)) > 2) {
                        return mm / (3600 * 24) + "days ago";
                    } else
                        return mm / (3600 * 24) + "day ago";
                }
            } else {
                if (mm < 60) {
                    return "一分钟前";
                } else if (mm > 60 && mm < 3600) {
                    return mm / 60 + "分钟前";
                } else if (mm >= 3600 && mm < 3600 * 24) {
                    return mm / 3600 + "小时前";
                } else {
                    return mm / (3600 * 24) + "天前";
                }
            }

        }
    }

    /**
     * 转换分钟 <1小时显示分钟 / <1天显示小时 / <1月显示天 / <1年显示月
     *
     * @param time 时间-分钟
     * @return timeStr string
     */

    public static String getMinuteTransformation(int time) {
        if (LanguageUtil.checkLanguage()) {
            if (time < 60) {
                if (time > 1) {
                    return time + " minutes";
                } else {
                    return time + " minute";
                }
            } else if (time < 60 * 24) {
                if (time / 60 > 1) {
                    return time / 60 + " hours";
                } else
                    return time / 60 + " hour";
            } else {
                if (time / (60 * 24) > 1)
                    return time / (60 * 24) + " days";
                else
                    return time / (60 * 24) + " day";

            }
        } else {
            if (time < 60) {
                return time + "分钟";
            } else if (time < 60 * 24) {
                return time / 60 + "小时";
            } else {
                return time / (60 * 24) + "天";
            }
        }
    }

    /**
     * 获取当月的 天数
     */
    public static int getCurrentMonthDay(Calendar calendar) {
        Calendar a = calendar;
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 将数字转为周
     */
    public static String getNumToDayOfWeek(int num) {
        switch (num) {
            case 0:
                return " 周一";
            case 1:
                return " 周二";
            case 2:
                return " 周三";
            case 3:
                return " 周四";
            case 4:
                return " 周五";
            case 5:
                return " 周六";
            case 6:
                return " 周日";
            default:
                return " 无效日期";
        }
    }
}
