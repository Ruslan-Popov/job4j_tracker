package ru.job4j.lambda;

import java.util.function.*;
import java.util.ArrayList;
import java.util.List;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filter(List<Attachment> atts, Predicate<Attachment> pre) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment attmnt : atts) {
            if (pre.test(attmnt)) {
                rsl.add(attmnt);
            }
        }
        return rsl;
    }
}
