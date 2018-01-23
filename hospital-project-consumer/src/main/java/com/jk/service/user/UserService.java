package com.jk.service.user;

import java.util.List;
import java.util.Map;

public interface UserService {


    long queryDataTotal();


    List<Map<String, Object>> findUser(Integer startPos, Integer pageSize);
}
