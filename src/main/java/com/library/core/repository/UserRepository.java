package com.library.core.repository;


import com.library.core.model.User;
import com.library.core.model.enums.UserType;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    @Aggregation(pipeline = """
            { $match: { _id: { $exists: true}}}
            """)
    List<User> findAllCustom();

    @Query(value = "{email:?0}", fields = "{'id': 1, 'firstname': 1, 'lastname': 1, 'email': 1, 'username': 1, 'userType': 1}")
    Optional<User> findByEmailCustom(String email);

    Optional<User> findByUsername(String username);

    List<User> findByEmailAndUserTypeOrderByCreationDateDesc(String email, UserType userType);
}
