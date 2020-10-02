package com.sj.dao;

import com.sj.model.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityMapper {

    @Options(useGeneratedKeys = true, keyProperty = "activityId", keyColumn = "activity_id")
    @Insert("insert into activity(" +
            "activity_type," +
            "activity_name," +
            "activity_title," +
            "activity_message," +
            "activity_describe," +
            "provider," +
            "create_time," +
            "online_time," +
            "deadline," +
            "activity_state," +
            "url" +
            ")value(#{activityType},#{activityName}," +
            "#{activityTitle}," +
            "#{activity_message}" +
            "#{activity_describe}," +
            "#{provider}," +
            "#{createTime}," +
            "#{onlineTime}," +
            "#{deadline}," +
            "#{activityState}," +
            "#{url})")
    void savePlan(Activity activity) throws Exception;

}
