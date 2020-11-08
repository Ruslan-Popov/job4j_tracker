package ru.job4j.tracker;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {
//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(
//                new String[]{"0", "Item name", "1"}
//        );
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {
//                new CreateAction(),
//                new ExitAction()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("Item name"));
//    }
//
//    @Test
//    public void whenReplaceItemAction() {
//        Tracker tracker = new Tracker();
//        Item item = new Item("Old item");
//        tracker.add(item);
//        Input in = new StubInput(
//                new String[]{"0", String.valueOf(item.getId()), "New item",  "1"}
//        );
//        UserAction[] actions = {
//                new ReplaceItemAction(),
//                new ExitAction()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("New item"));
//    }
//
//    @Test
//    public void whenDeleteItemAction() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("First item"));
//        Input in = new StubInput(
//                new String[] {"0", String.valueOf(item.getId()), "1"}
//        );
//        UserAction[] actions = {
//                new DeleteItemAction(),
//                new ExitAction()
//        };
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
}