package com.fis.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fis.model.Member;

@Repository
public interface MemberDao extends CrudRepository<Member, Long> {
    Member findByUsername(String username);
}