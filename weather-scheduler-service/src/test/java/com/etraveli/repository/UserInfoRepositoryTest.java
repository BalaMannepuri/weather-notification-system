package com.etraveli.repository;

import com.etraveli.model.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserInfoRepositoryTest {

    @Mock
    private UserInfoRepository repo;

    @Test
    public void getUsersTest() {
        List<UserInfo> mockUserList = new ArrayList<>();
        mockUserList.add(new UserInfo(1L, "Prasanna", "abc@gmail.com", "pune", "1234567890", 20, true, true, true));
        mockUserList.add(new UserInfo(2L, "Bala", "bcd@gmail.com", "Bangalore", "1234567891", 21, true, true, true));
        mockUserList.add(new UserInfo(3L, "Murali", "cde@gmail.com", "Mumbai", "1234567892", 22, true, true, true));
        Mockito.when(repo.getUserInfo()) .thenReturn(mockUserList);
        List<UserInfo> userList = repo.getUserInfo();
        Assertions.assertNotNull(userList);
    }
}
