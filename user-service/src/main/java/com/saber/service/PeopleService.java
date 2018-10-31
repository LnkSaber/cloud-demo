package com.saber.service;

import com.saber.mapper.PeopleMapper;
import com.saber.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeopleService {
    @Autowired
    private PeopleMapper peopleMapper;

    public People queryById(Integer id){
        return peopleMapper.selectByPrimaryKey(id);
    }
}
