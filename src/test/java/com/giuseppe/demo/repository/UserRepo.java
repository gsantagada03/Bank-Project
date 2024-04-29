package com.giuseppe.demo.repository;

import org.springframework.data.repository.CrudRepository;



import com.giuseppe.demo.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	boolean existsByUsername (String username);
	boolean existsByPhone  (String phone);
	boolean existsByPassword (String password);
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);

}
