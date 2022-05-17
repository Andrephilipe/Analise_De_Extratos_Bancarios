package com.acc.twootr;

import java.util.Optional;

public interface UserRepository {
    boolean add(User user);

    Optional<User> get(User user);

    void update(User user);

    void clear();

    FollowStatus follow(User follower. User userToFollow);
}
