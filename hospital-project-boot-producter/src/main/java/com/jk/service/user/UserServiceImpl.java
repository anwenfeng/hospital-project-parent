package com.jk.service.user;

import com.jk.dao.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //查询数据总数
    public long queryDataTotal() {

        return userMapper.queryDataTotal();
    }

    //查询并分页
    public List<Map<String, Object>> findUser(Integer startPos, Integer pageSize) {

        return userMapper.findUser(startPos,pageSize);
    }

}
