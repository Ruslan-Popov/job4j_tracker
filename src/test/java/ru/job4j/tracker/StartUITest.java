package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. ==== Exit program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenShowAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAllAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. ==== Show all items ====" + System.lineSeparator() +
                        "1. ==== Exit program ====" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. ==== Show all items ====" + System.lineSeparator() +
                        "1. ==== Exit program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new SearchItemWithIDAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. ==== Find item by id ====" + System.lineSeparator() +
                        "1. ==== Exit program ====" + System.lineSeparator() +
                        "There is no item with such ID" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. ==== Find item by id ====" + System.lineSeparator() +
                        "1. ==== Exit program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenSearchItemsWithNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "First", "1"}
        );
        Item first = new Item("First");
        Tracker tracker = new Tracker();
        tracker.add(first);
        UserAction[] actions = {
                new SearchItemsWithNameAction(out), new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. ==== Find items by name ====" + System.lineSeparator() +
                        "1. ==== Exit program ====" + System.lineSeparator() +
                        "Found First with IDs:" + System.lineSeparator() +
                        "1" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. ==== Find items by name ====" + System.lineSeparator() +
                        "1. ==== Exit program ====" + System.lineSeparator()
        ));
    }
}