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

    // io 추상화 필요
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

            List<StudyCafePass> findPasses = findPassesByPassType(passType);
            outputHandler.showPassListForSelection(findPasses);
            StudyCafePass selectedPass = inputHandler.getSelectPass(findPasses);

            // 사물함 사용 정책 확장 고려
            if (isAvailableLockerAt(passType)) {
                StudyCafeLockerPass lockerPass = findLockerPass(selectedPass);

                outputHandler.askLockerPass(lockerPass);

                boolean lockerSelection = inputHandler.getLockerSelection();
                outputHandler.showPassOrderSummary(selectedPass, lockerSelection ? lockerPass : null);
            } else {
                outputHandler.showPassOrderSummary(selectedPass, null);
            }

        } catch (AppException e) {
            outputHandler.showSimpleMessage(e.getMessage());
        } catch (Exception e) {
            outputHandler.showSimpleMessage("알 수 없는 오류가 발생했습니다.");
        }
    }

    private boolean isAvailableLockerAt(StudyCafePassType passType) {
        return lockerPasses.stream()
            .anyMatch(option -> option.getPassType() == passType);
    }

    private StudyCafeLockerPass findLockerPass(StudyCafePass selectedPass) {
        return lockerPasses.stream()
            .filter(option ->
                option.getPassType() == selectedPass.getPassType()
                    && option.getDuration() == selectedPass.getDuration()
            )
            .findFirst()
            .orElse(null);
    }

    private List<StudyCafePass> findPassesByPassType(StudyCafePassType passType) {
        return studyCafePasses.stream()
            .filter(pass -> pass.getPassType() == passType)
            .toList();
    }

}
