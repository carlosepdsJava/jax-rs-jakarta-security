package sh.platform.sample.security;

import jakarta.nosql.mapping.Repository;

import javax.decorator.Decorator;
import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Stream;

@ApplicationScoped
interface UserRepository extends Repository<User, String> {

    Stream<User> findAll();
}
