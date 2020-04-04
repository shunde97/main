package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ViewCalendarCommand.SHOWING_CALENDAR_MESSAGE;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class ViewCalendarCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_calendar_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_CALENDAR_MESSAGE, true, false, false, false);
        assertCommandSuccess(new ViewCalendarCommand(), model, expectedCommandResult, expectedModel);
    }
}
