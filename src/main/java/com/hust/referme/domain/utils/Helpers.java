package com.hust.referme.domain.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class Helpers {

    public static boolean regexUsername(String username) {
        if (username == null) {
            return false;
        }
        String regex = "^[a-zA-Z0-9._]{6,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.find();
    }

    public static boolean regexPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        String regex = "^0[37859]{1}[0-9]{1}\\d{7}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    public static boolean regexEmail(String email) {
        if (email == null) {
            return false;
        }
        String regex =
                "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }

    public static boolean regexUrl(String url) {
        if (url == null) {
            return false;
        }
        String regex =
                "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.find();
    }

    public static int generateOTP() {
        Random r = new Random(System.currentTimeMillis());
        return ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
    }

//  public static String md5Token(String token) {
//    return DigestUtils.sha256Hex(token);
//  }

    public static Date dateFormat(Date date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(date);
        return formatter.parse(strDate);
    }

    public static boolean compareDate(Date dateField) {
        if (dateField == null) {
            return false;
        }
        long millis = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        String stringDate = formatter.format(new Date(millis));
        String inputDate = formatter.format(dateField);
        try {
            Date currentDate = formatter.parse(stringDate);
            Date birthDay = formatter.parse(inputDate);
            int status = birthDay.compareTo(currentDate);
            if (status == 1) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String refundTransactionCode() {
        String code = UUID.randomUUID() + "";
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        code = code.replaceAll("\\D+", "") + ts.getTime() + "";

        return "RF" + code.substring(0, 18);
    }

//  public static String replaceImageUrl(String imageUrl, String size) {
//    String url = StringUtils.substringBeforeLast(imageUrl, "/");
//    String image = StringUtils.substringAfterLast(imageUrl, "/");
//    url = url + size + image;
//    return url;
//  }

    public static Integer getOffsetTimeZone(HttpServletRequest request) {
        Locale clientLocale = request.getLocale();
        log.info(clientLocale.toString() + "================================== ");
        Calendar client = Calendar.getInstance(clientLocale);
        TimeZone clientTimeZone = client.getTimeZone();

        Calendar server = Calendar.getInstance();
        TimeZone serverTimeZone = server.getTimeZone();

        int clientTimeZoneRawOffset = clientTimeZone.getRawOffset();
        int serverTimeZoneRawOffset = serverTimeZone.getRawOffset();
        Integer a = (serverTimeZoneRawOffset / 1000 / 60 / 60);
        Integer b = (clientTimeZoneRawOffset / 1000 / 60 / 60);

        log.info(a + "_" + b);
        return (serverTimeZoneRawOffset / 1000 / 60 / 60) - (clientTimeZoneRawOffset / 1000 / 60 / 60);
    }
}
