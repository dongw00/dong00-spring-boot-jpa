package com.dongwoo.api.designPatterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandTest {

    @DisplayName("Command pattern")
    @Test
    void main() {
        AirConditioner airConditioner = new AirConditioner();
        AircRemoteControl control = new AircRemoteControl();

        control.setCommand(airConditioner::turnOn);
        control.buttonPressed();

        control.setCommand(airConditioner::turnOff);
        control.buttonPressed();

        control.setCommand(airConditioner::increaseTemp);
        control.buttonPressed();

        control.setCommand(airConditioner::decreaseTemp);
        control.buttonPressed();
    }

    interface Command {

        void execute();
    }

    class AirConditioner {

        void turnOn() {
            System.out.println("에어콘 켜기");
        }

        void turnOff() {
            System.out.println("에어콘 끄기");
        }

        void increaseTemp() {
            System.out.println("온도 올리기");
        }

        void decreaseTemp() {
            System.out.println("온도 내리기");
        }
    }

    class AircRemoteControl {

        Command command;

        void setCommand(Command command) {
            this.command = command;
        }

        void buttonPressed() {
            command.execute();
        }
    }
}
