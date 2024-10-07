package org.example.etc.inflearn.readablecode.mission.day07.studycafe;

import org.example.etc.inflearn.readablecode.mission.day07.studycafe.exception.AppException;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.io.InputHandler;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.io.OutputHandler;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.io.StudyCafeFileHandler;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafeLockerPass;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafePass;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafePassType;

import java.util.List;

public class StudyCafePassMachine {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    private final List<StudyCafePass> studyCafePasses;
    private final List<StudyCafeLockerPass> lockerPasses;

    public StudyCafePassMachine(StudyCafeFileHandler studyCafeFileHandler) {
        this.studyCafePasses = studyCafeFileHandler.readStudyCafePasses();
        this.lockerPasses = studyCafeFileHandler.readLockerPasses();
    }

    public void run() {
        try {
            outputHandler.showWelcomeMessage();
            outputHandler.showAnnouncement();
            outputHandler.askPassTypeSelection();

            StudyCafePassType passType = inputHandler.getPassTypeSelectingUserAction();
            List<StudyCafePass> passes = showPassesOf(passType);

            StudyCafePass selectedPass = inputHandler.getSelectPassFromUser(passes);
            StudyCafeLockerPass lockerPass = findLockerPassBy(selectedPass);

            outputHandler.showPassOrderSummary(selectedPass, lockerPass);
        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private List<StudyCafePass> showPassesOf(StudyCafePassType passType) {
        List<StudyCafePass> passes = findPassesBy(passType);
        outputHandler.showPassesForSelection(passes);
        return passes;
    }

    private List<StudyCafePass> findPassesBy(StudyCafePassType passType) {
        return studyCafePasses.stream()
                .filter(pass -> pass.getPassType() == passType)
                .toList();
    }

    private StudyCafeLockerPass findLockerPassBy(StudyCafePass selectedPass) {
        if (isLockerUnavailableFor(selectedPass.getPassType())) {
            return null;
        }

        StudyCafeLockerPass lockerPass = lockerPasses.stream()
                .filter(selectedPass::isSameDurationAndType)
                .findFirst()
                .orElse(null);

        if (lockerPass != null) {
            outputHandler.askLockerPass(lockerPass);
            boolean isLockerSelected = inputHandler.getLockerSelection();

            if (isLockerSelected) {
                return lockerPass;
            }
        }

        return null;
    }

    private boolean isLockerUnavailableFor(StudyCafePassType passType) {
        return lockerPasses.stream()
            .noneMatch(option -> option.getPassType() == passType);
    }

}
