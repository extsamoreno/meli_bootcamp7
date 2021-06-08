package com.meli.desafio1.web.service;

import com.meli.desafio1.web.model.Follow;
import com.meli.desafio1.web.repository.IFollowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    IFollowRepository iFollowRepository;
    @Override
    /*
    public int follow(int userId, int follow_id) {
        System.out.println("Entró a follow");
        System.out.println(iFollowRepository.getFollowList());
        List<Follow> followList = iFollowRepository.getFollowList();

        System.out.println(followList.size());
        for (Follow follow : followList) {
            System.out.println("Entró a for");
            if (follow.getUserId() == userId) {
                List<Integer> followListId = follow.getFollows_id();
                if (!followListId.contains(follow_id)) {

                    followListId.add(follow_id);
                    follow.setFollows_id(followListId);


                    return 1;
                }
                else {
                    return 0;
                }

            }

        }
        return -1;
    }
    */

    public int follow(int userId, int follow_id) {
        System.out.println("Entró a follow");
        System.out.println(iFollowRepository.loadDataFollow());


        return -1;
    }


}
