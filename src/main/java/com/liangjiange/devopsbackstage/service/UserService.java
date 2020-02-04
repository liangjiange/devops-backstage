package com.liangjiange.devopsbackstage.service;

import com.liangjiange.devopsbackstage.entity.User;

public interface UserService {

    User getByUsername(String username);

}
