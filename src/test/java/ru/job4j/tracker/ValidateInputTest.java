package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {
    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        List<String> stringList = Arrays.asList("2", "0");
        Input in = new StubInput(
                stringList
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitAction(out));
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
        List<String> stringList = Arrays.asList("one", "1");
        Input in = new StubInput(
                stringList
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        List<String> stringList = Arrays.asList("10");
        Input in = new StubInput(
                stringList
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu");
        assertThat(selected, is(10));
    }

    @Test(expected = NumberFormatException.class)
    public void whenOutput() {
        List<String> stringList = Arrays.asList("exit", "0");
        Input in = new StubInput(
                stringList
        );
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(new ExitAction(out));
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