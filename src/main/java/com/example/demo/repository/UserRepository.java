package com.example.demo.repository;

import com.example.demo.entity.User;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Zhang Xiao
 * @date 12/14/2018 16:04
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByName(String name);
    List<User> findByEmail(String email);


}
