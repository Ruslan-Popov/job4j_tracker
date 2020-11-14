package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"exit", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is (
                String.format(
                        "Menu.%n"
                        + "0. ==== Exit program ====" + System.lineSeparator()
                        + "Wrong input, you can select: 0 ... 0%n"
                        + "Menu.%n"
                        + "0. ==== Exit program ====%n"
                )
        ));
    }
}