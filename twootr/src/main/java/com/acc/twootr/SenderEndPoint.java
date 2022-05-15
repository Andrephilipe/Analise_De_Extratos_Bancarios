package com.acc.twootr;

import java.util.Objects;

public class SenderEndPoint {
    private final User user;
    private final Twootr twootr;

    SenderEndPoint(final User user, final Twootr twootr) {
        Objects.requireNonNull(user, "user");
        Objects.requireNonNull(twootr, "twootr");

        this.user = user;
        this.twootr = twootr;
    }

    public FollowStatus onFollow(final String userIdToFollow){
        Objects.requireNonNull(userIdToFollow, "userIdFollow");

        return twootr.onFollow(user, userIdToFollow);
    }

    void onSenderTwoot(final String id, final User user, final String content){

        final String usedId = user.getId();
        final Twoot twoot = new Twoot(id, usedId, content);
        user.followers()
                .filter(User::isLoggedOn)
                .forEach(follower -> follower.receiveTwoot(twoot));
    }
}
