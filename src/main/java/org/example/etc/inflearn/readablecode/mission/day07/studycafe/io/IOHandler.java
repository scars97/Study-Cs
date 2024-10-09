package org.example.etc.inflearn.readablecode.mission.day07.studycafe.io;

import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafeLockerPass;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafePass;
import org.example.etc.inflearn.readablecode.mission.day07.studycafe.model.StudyCafePassType;

import java.util.List;

public class IOHandler {

    private final InputHandler inputHandler = new InputHandler();
    private final OutputHandler outputHandler = new OutputHandler();

    public void showWelcomeMessage() {
        outputHandler.showWelcomeMessage();
    }

    public void showAnnouncement() {
        outputHandler.showAnnouncement();
    }

    public StudyCafePassType askPassTypeToUser() {
        outputHandler.askPassTypeSelection();
        return inputHandler.getPassTypeSelectingUserAction();
    }

    public StudyCafePass getSelectPassFromUser(List<StudyCafePass> passes) {
        outputHandler.showPassesForSelection(passes);
        return inputHandler.getSelectPassFromUser(passes);
    }

    public boolean askEnableLockerPassToUser(StudyCafeLockerPass lockerPass) {
        outputHandler.askLockerPass(lockerPass);
        return inputHandler.getLockerSelection();
    }

    public void showPassOrderSummary(StudyCafePass selectedPass, StudyCafeLockerPass lockerPass) {
        outputHandler.showPassOrderSummary(selectedPass, lockerPass);
    }

    public void showSimpleMessage(String message) {
        outputHandler.showSimpleMessage(message);
    }
}
