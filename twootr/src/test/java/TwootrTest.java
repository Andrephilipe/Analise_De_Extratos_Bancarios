import com.acc.twootr.SenderEndPoint;
import com.acc.twootr.Twoot;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class TwootrTest {
    Optional<SenderEndPoint> onLogon(String userId, ReceiverEndPoint receiver);
    @Test
    public void shouldBeAbleToAuthenticateUser(){

    }
    @Test
    public void shouldNoAuthenticateUserWithWrongPassword(){
        final Optional<SenderEndPoint> endPoint = twootr.onLogon(
                TestData.USER_ID, "bad password", receiverEndPoint);
        assertFalse(endPoint.isPresent());
    }

    @Test
    public void shouldFollowValidUser(){
        logon();
        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);

        assertEquals(SUCCESS, followStatus);
    }

    @Test
    public void shouldNotDuplicateFollowValidUser(){
        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);

        final FollowStatus followStatus = endPoint.onFollow(TestData.OTHER_USER_ID);
        assertEquals(SLREADY_FOLLOWING, followStatus);
    }

    @Test
    public void shouldReceiveTwootsFromFollowedUser(){
        final String id = "1";

        logon();

        endPoint.onFollow(TestData.OTHER_USER_ID);
        final SenderEndPoint otherEndPoint = otherLogon();
        otherEndPoint.onSendTwoot(id, TWOOT);

        verify(twootRepository).add(id, TestData.OTHER_USER_ID, TWOOT);
        verify(receiverEndPoint).onTwoot(new Twoot(id, TestData.OTHER_USER_ID, TWOOT, new Position(0)));
    }
}
