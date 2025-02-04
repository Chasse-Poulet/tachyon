package demo.tachyon.repository;

import demo.tachyon.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByDisplayName(String displayName);
}
