package com.acc.twootr;

import java.util.ArrayList;
import java.util.List;

public class MockReceiverEndPoint {
    private final ReceiverEndPoint receiverEndPoint = mock(ReceiverEndPoint.class);
    private final List<Twoot> receivedTwoots = new ArrayList<>();

    @Override
    public void onTwoot(final Twoot twoot){
        receivedTwoots.add(twoot);
    }
    public void verifyOnTwoot(final Twoot twoot){
        assertThat(
                receivedTwoots,
                contains(twoot));
    }
}
