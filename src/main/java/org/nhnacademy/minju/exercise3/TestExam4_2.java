package org.nhnacademy.minju.exercise3;

import java.time.LocalDateTime;

public class TestExam4_2 {
    public static void main(String[] args) {
        Pipe pipe = new Pipe();
        Thread sender = new Thread(new Sender(pipe));
        Thread sender2 = new Thread(new Sender(pipe));
        Thread receiver = new Thread(new Receiver(pipe, 9));
        Thread.State senderPreviousState;
        Thread.State sender2PreviousState;
        Thread.State receiverPreviousState;

        sender.start();
        sender2.start();
        receiver.start();

        senderPreviousState = sender.getState();
        sender2PreviousState = sender2.getState();
        receiverPreviousState = receiver.getState();

        while (!Thread.interrupted()
                && ((sender.getState() != Thread.State.TERMINATED)
                && (receiver.getState() != Thread.State.TERMINATED))) {

            Thread.State senderState = sender.getState();
            Thread.State sender2State = sender2.getState();
            Thread.State receiverState = receiver.getState();
            try {
                if ((senderPreviousState != senderState)
                        || (receiverPreviousState != receiverState)
                        || (sender2PreviousState != sender2State)) {
                    System.out.println("[ " + LocalDateTime.now() + " ]"
                            + " Sender : " + senderState
                            + ", Sender2 : " + sender2State
                            + ", Receiver : " + receiverState);
                    senderPreviousState = senderState;
                    sender2PreviousState = sender2State;
                    receiverPreviousState = receiverState;
                }

                Thread.sleep(10);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
