package com.home.executer.api.service;

import com.home.executer.api.entity.User;
import com.home.executer.api.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Async
    public CompletableFuture<List<User>> saveUser(MultipartFile multipartFile)  {
        try {
            long currentTime = System.currentTimeMillis();
            var users = parseUserFile(multipartFile);
            logger.info("Saving data to data base with records {} and current thread {}", users.size(), Thread.currentThread().getName());
            logger.info("Saving data to data base with records {} ", users);

            users = userRepository.saveAllAndFlush(users);
            long endTime = System.currentTimeMillis();
            logger.info("Time taken to insert data is{} ", endTime - currentTime);

            return CompletableFuture.completedFuture(users);
        }catch (Exception ex) {
            logger.error("Error while saving data",ex);
            return null;
        }
    }

    @Async
    public CompletableFuture<List<User>> getAllUsers(){
        logger.info("Getting data to data base  current thread {}",Thread.currentThread().getName());
        return CompletableFuture.completedFuture(userRepository.findAll());

    }
    public List<User> parseUserFile(MultipartFile file) throws Exception {

        var listOfUsers = new ArrayList<User>();
        try {
            logger.debug("file -->{}",file);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                String line;
                while ((line = br.readLine()) != null) {
                    logger.debug("line -->{}",line);
                    String[] values = line.split(",");
                    User user =new User();
                    user.setName(values[0]);
                    user.setEmail(values[1]);
                    user.setGender(values[2]);
                    listOfUsers.add(user);
                }

            }
            return listOfUsers;
        } catch (Exception e) {
            throw new Exception("Unable to parse data");

        }
    }
}
