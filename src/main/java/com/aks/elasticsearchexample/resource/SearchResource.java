package com.aks.elasticsearchexample.resource;

import com.aks.elasticsearchexample.model.Users;
import com.aks.elasticsearchexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * author anand.
 * since on 29/4/18.
 */
@RestController
@RequestMapping("/rest/search")
public class SearchResource {

    @Autowired
    UsersRepository usersRepository;

    @RequestMapping("/name/{text}")
    private List<Users> searchName(@PathVariable final String text){
        return usersRepository.findByName(text);
    }

    @RequestMapping("/salary/{salary}")
    private List<Users> searchSalary(@PathVariable final Long salary){
        return usersRepository.findBySalary(salary);
    }

    @RequestMapping("/all")
    private List<Users> findAll(){

        List<Users> usersList=new ArrayList<>();
        Iterable<Users> all=usersRepository.findAll();
        //all.forEach(user->usersList.add(user));
        all.forEach(usersList::add);
        return usersList;
    }
}
