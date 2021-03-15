package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.parser.MarkdownPlainTextParser;
import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {
    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + " [COMMAND]" + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD + " find";

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    public static final String HELP_TITLE = "Commands available";
    public static final String FEATURES_HEADING = "## Features";

    private String helpMessage = "";
    private final String specifiedCommand;

    private final Logger logger = LogsCenter.getLogger(HelpCommand.class);

    public HelpCommand() {
        this.specifiedCommand = "";
    }

    /**
     * Constructs a {@HelpCommand} with the specified {@specifiedCommand}.
     * @param specifiedCommand  Command supported by the app and documented in the user guide
     */
    public HelpCommand(String specifiedCommand) {
        requireNonNull(specifiedCommand);
        this.specifiedCommand = specifiedCommand;
    }

    @Override
    public CommandResult execute(Model model) {
        if (specifiedCommand != "") {
            return executeSpecific(specifiedCommand);
        } else {
            return executeNonSpecific();
        }

    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof HelpCommand // instanceof handles nulls
                && specifiedCommand.equals(((HelpCommand) other).specifiedCommand)); // state check
    }

    private CommandResult executeSpecific(String specifiedCommand) {
        String plainCommandTitle = "";
        String plainCommandInfo = "";

        try {
            String projectDir = System.getProperty("user.dir");
            BufferedReader reader = new BufferedReader(new FileReader(projectDir + "/docs/UserGuide.md"));

            String currLine = reader.readLine();
            while (currLine != null && !currLine.equals(FEATURES_HEADING)) {
                currLine = reader.readLine();
            }

            currLine = reader.readLine();
            while (currLine != null) {
                String[] splitSubheading = currLine.split("`");

                if (currLine.startsWith("###") && splitSubheading[1].equals(specifiedCommand)) {
                    break;
                }

                currLine = reader.readLine();
            }

            MarkdownPlainTextParser parser = new MarkdownPlainTextParser();
            String commandTitle = currLine;
            String commandInfo = "";

            reader.readLine();

            currLine = reader.readLine();
            while (!currLine.startsWith("###") && !currLine.startsWith("---")) {
                commandInfo += currLine + "\n";
                currLine = reader.readLine();
            }

            plainCommandTitle = parser.formatPlainText(commandTitle, "title");
            plainCommandInfo = parser.formatPlainText(commandInfo, "info");

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }

        return new CommandResult(SHOWING_HELP_MESSAGE, plainCommandTitle, plainCommandInfo, true, false);
    }

    private CommandResult executeNonSpecific() {
        try {
            String projectDir = System.getProperty("user.dir");
            BufferedReader reader = new BufferedReader(new FileReader(projectDir + "/docs/UserGuide.md"));

            String currLine = reader.readLine();
            while (currLine != null && !currLine.equals("--------|------------------")) {
                currLine = reader.readLine();
            }

            currLine = reader.readLine();
            while (currLine != null) {
                helpMessage += commandSummaryParser(currLine);
                currLine = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }

        return new CommandResult(SHOWING_HELP_MESSAGE, HELP_TITLE, helpMessage, true, false);
    }

    private String commandSummaryParser(String info) {
        String[] separatedInfo = info.split("\\|");
        String[] commandName = separatedInfo[0].split("\\*");
        String[] commandDesc = separatedInfo[1].split("`");

        return commandName[2] + ": " + commandDesc[1] + "\n";
    }
}
