package com.aks.elasticsearchexample.load;

import com.aks.elasticsearchexample.model.Users;
import com.aks.elasticsearchexample.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * author anand.
 * since on 29/4/18.
 */
@Component
public class Loaders {

    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UsersRepository usersRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(Users.class);
        System.out.println("loading data");
        usersRepository.save(getData());
        System.out.println("loading completed");

    }

    private List<Users> getData(){
        List<Users> usersList=new ArrayList<>();
        usersList.add(new Users("anand",123L,"engineer",30000L));
        usersList.add(new Users("amit",103L,"finance",20000L));
        usersList.add(new Users("raja",129L,"teacher",30000L));
        usersList.add(new Users("tin",178L,"clark",19000L));
        usersList.add(new Users("waseem",153L,"politician",39000L));
        return usersList;
    }
}
