package org.example.etc.inflearn.readablecode.mission.day07.studycafe;

import org.example.etc.inflearn.readablecode.mission.day07.studycafe.exception.AppException;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.io.IOHandler;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.io.StudyCafeFileHandler;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafeLockerPass;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafePass;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final IOHandler ioHandler = new IOHandler();
    private final StudyCafeFileHandler studyCafeFileHandler = new StudyCafeFileHandler();

    public void run() {
        try {
            ioHandler.showWelcomeMessage();
            ioHandler.showAnnouncement();

            StudyCafePass selectedPass = selectPass();
            StudyCafeLockerPass lockerPass = selectLockerPass(selectedPass);

            ioHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (AppException e) {
            ioHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            ioHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private StudyCafePass selectPass() {
        StudyCafePassType passType = ioHandler.askPassTypeToUser();
        List<StudyCafePass> passes = findPassesBy(passType);

        return ioHandler.getSelectPassFromUser(passes);
    }

    private List<StudyCafePass> findPassesBy(StudyCafePassType passType) {
        List<StudyCafePass> studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
        return studyCafePasses.stream()
                .filter(pass -> pass.getPassType() == passType)
                .toList();
    }

    private StudyCafeLockerPass selectLockerPass(StudyCafePass selectedPass) {
        if (selectedPass.isLockerUnavailable()) {
            return null;
        }

        StudyCafeLockerPass lockerPass = findLockerPassBy(selectedPass);

        if (lockerPass != null) {
            boolean isLockerSelected = ioHandler.askEnableLockerPassToUser(lockerPass);

            if (isLockerSelected) {
                return lockerPass;
            }
        }

        return null;
    }

    private StudyCafeLockerPass findLockerPassBy(StudyCafePass selectedPass) {
        List<StudyCafeLockerPass> lockerPasses = studyCafeFileHandler.readLockerPasses();

        return lockerPasses.stream()
                .filter(selectedPass::isSameDurationAndType)
                .findFirst()
                .orElse(null);
    }

}
