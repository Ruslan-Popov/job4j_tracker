package ru.job4j.pojo;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LicenseTest {
    @Test
    public void eqName() {
        License a = new License();
        a.setCode("audio");
        License b = new License();
        b.setCode("audio");
        assertThat(a, is(b));
    }
}