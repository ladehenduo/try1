package com.wang.service.quarantineService;

import com.wang.pojo.QuarantinePeople;

import java.util.Date;
import java.util.List;

public interface QuarantineService {
    public List<QuarantinePeople> getAllQuarantine();
    public boolean addQuarantinePeople(String username, String date, int day, String room);
    public boolean deleteQuarantinePeople(String username);
    public boolean updateQurantinePeople(String username, String type, String date, int day, String room);
}
