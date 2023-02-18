package com.etraveli.repository;

import com.etraveli.model.UserInfo;
import org.apache.log4j.Logger;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserInfoRepository {

    private Logger logger = Logger.getLogger(UserInfoRepository.class);

    @Cacheable("users")
    public List<UserInfo> getUserInfo() {
        logger.info("Getting User info");
        List<UserInfo> usersList = new ArrayList<>();
        usersList.add(new UserInfo(1L, "Prasanna", "abc@gmail.com", "pune", "1234567890", 20, true, true, true));
        usersList.add(new UserInfo(2L, "Bala", "bcd@gmail.com", "Bangalore", "1234567891", 21, true, true, true));
        usersList.add(new UserInfo(3L, "Murali", "cde@gmail.com", "Mumbai", "1234567892", 22, true, true, true));
        usersList.add(new UserInfo(4L, "Hema", "def@gmail.com", "Hyderabad", "1234567893", 23, true, true, true));
        usersList.add(new UserInfo(5L, "Madhavi", "efg@gmail.com", "Mumbai", "1234567894", 24, true, true, true));
        usersList.add(new UserInfo(6L, "Deepthi", "fgh@gmail.com", "Delhi", "1234567895", 19, true, true, true));
        usersList.add(new UserInfo(7L, "Himaja", "ghi@gmail.com", "Hyderabad", "1234567896", 18, true, true, true));
        usersList.add(new UserInfo(8L, "Bhavya", "hij@gmail.com", "Bangalore", "1234567897", 17, true, true, true));
        usersList.add(new UserInfo(9L, "Prajjwal", "ijk@gmail.com", "pune", "1234567898", 16, true, false, false));
        usersList.add(new UserInfo(10L, "Madhu", "jkl@gmail.com", "Mumbai", "1234567899", 15, true, true, true));
        usersList.add(new UserInfo(11L, "Bhargavi", "klm@gmail.com", "Bangalore", "1234567900", 30, true, true, true));
        usersList.add(new UserInfo(12L, "Prasad", "lmn@gmail.com", "pune", "1234567901", 31, true, true, true));
        usersList.add(new UserInfo(13L, "Hari", "mno@gmail.com", "Hyderabad", "1234567902", 32, true, true, true));
        usersList.add(new UserInfo(14L, "Mahesh", "nop@gmail.com", "Mumbai", "1234567903", 33, true, true, true));
        usersList.add(new UserInfo(15L, "Bunny", "opq@gmail.com", "Bangalore", "1234567904", 34, true, true, true));
        usersList.add(new UserInfo(16L, "Phani", "pqr@gmail.com", "pune", "1234567905", 35, true, true, true));
        return usersList;
    }
}
