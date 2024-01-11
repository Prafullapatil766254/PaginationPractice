package com.practice.Service;

import com.practice.Entity.User;
import com.practice.Repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;

    public ResponseEntity<?> addUser(User user) {
        userRepo.save(user);
        return new ResponseEntity<>("User added successfully" , HttpStatus.OK);
    }

    public ResponseEntity<?> getUserById(Integer id) {
        User user = userRepo.findById(id).orElse(null);

        if(!user.equals(null)){
            return new ResponseEntity<>(user , HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User not found" , HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getAllUsers(Integer pageSize, Integer pageNo , String sortBy) {
        Pageable pageable = PageRequest.of(pageNo , pageSize , Sort.by(sortBy));
        Page<User> page = userRepo.findAll(pageable);
        List<User> content = page.getContent();
        return new ResponseEntity<>(content , HttpStatus.OK);
    }
}
