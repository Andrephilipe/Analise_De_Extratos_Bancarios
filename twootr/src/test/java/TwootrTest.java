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
}
'