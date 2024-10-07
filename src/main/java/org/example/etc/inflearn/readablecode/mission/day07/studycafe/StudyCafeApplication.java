package org.example.etc.inflearn.readablecode.mission.day07.studycafe;

import org.example.etc.inflearn.readablecode.mission.day07.studycafe.io.StudyCafeFileHandler;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(studyCafeFileHandler);
        studyCafePassMachine.run();
    }

}
