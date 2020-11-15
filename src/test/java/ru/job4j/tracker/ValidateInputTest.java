package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. ==== Exit program ====" + System.lineSeparator()
                                + "Wrong input, you can select: 0 ... 0%n"
                                + "Menu.%n"
                                + "0. ==== Exit program ====%n"
                )
        ));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"10"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(10));
    }

    @Test(expected = NumberFormatException.class)
    public void whenOutput() {
        Input in = new StubInput(
                new String[]{
            "exit", "0"
        }
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. ==== Exit program ====%n"
                                + "Please enter valid data again."
                                + "Menu.%n"
                                + "0. ==== Exit program ====%n"
                )
        ));
    }
}