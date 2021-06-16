package com.meli.desafio1.web.repository;

import com.meli.desafio1.web.dto.FollowDTO;
import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.model.Npost;

import java.util.List;

public interface IFollowRepository {
    public List<Follow> getFollowList();
    public void setFollowList(List <Follow> followList);
    public Follow getFollowById(int userId);


}
