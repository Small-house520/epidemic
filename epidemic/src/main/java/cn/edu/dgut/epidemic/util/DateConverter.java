package cn.edu.dgut.epidemic.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * 自定义日期转换器
 */
@Component
public class DateConverter implements Converter<String, Date> {
	public static Logger logger = Logger.getLogger(DateConverter.class);

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        Date date = null;
        try {
            date = sdf.parse(s);
        } catch (ParseException e) {
            logger.error("转换提交的参数" + s + "为日期值时出错:" + e.getMessage());
        }
        return date;
    }
}
