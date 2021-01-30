package com.penchala.yegu.user.Service;

import com.penchala.yegu.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    List<User> userList = new ArrayList<>();
    public  boolean authenticate(String userId, String password) {
        initalizeMockUserData();
        for (User user: userList) {
           if(user.getUserId().equals(userId)){
              if(user.getPassword().equals(password))
                  return true;
           }
           log.info("Password does not matched for the user with userId"+userId);
        }
        log.info("The username provided does not exist in the database for userId "+userId);
        return false;
    }

    private void initalizeMockUserData() {
        userList.add(new User("siva3060","password"));
        userList.add(new User("yramya","password"));
    }
}


//Using Maps
//Using Spring Security
//Encrypting Password
//executing part of code only on bean load
