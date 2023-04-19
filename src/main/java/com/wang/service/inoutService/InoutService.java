package com.wang.service.inoutService;

import com.wang.pojo.Record;

import java.text.ParseException;
import java.util.List;

public interface InoutService {
    public List<Record> getAllRecord() throws ParseException;   // 查询所有的进出记录
    public boolean addRecord(String username, String inout_type, String time);    //  添加记录出传入记录
    public boolean updateRecord(String username, String inout_type, String time, String oldTime); //更新记录 传入新记录
    public boolean deleteRecord(String username, String time);  // 删除记录，传入用户名和记录的日期
}
