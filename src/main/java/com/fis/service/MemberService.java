package com.fis.service;

import java.util.List;

import com.fis.model.Member;

public interface MemberService {

    Member save(Member user);
    List<Member> findAll();
    void delete(long id);
}