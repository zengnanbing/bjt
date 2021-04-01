package com.zeng.bjt.mapper;

import com.zeng.bjt.model.MailSendLog;

public interface MailSendLogmapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MailSendLog record);

    int insertSelective(MailSendLog record);

    MailSendLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MailSendLog record);

    int updateByPrimaryKey(MailSendLog record);
}