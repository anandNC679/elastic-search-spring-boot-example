package com.aks.elasticsearchexample.repository;

import com.aks.elasticsearchexample.model.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * author anand.
 * since on 29/4/18.
 */
public interface UsersRepository extends ElasticsearchRepository<Users,Long> {
    List<Users> findByName(String text);
    List<Users> findBySalary(Long salary);
}
