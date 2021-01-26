package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProfileTest {
    @Test
    public void whenMap() {
        Address address1 = new Address("SPb", "Nevskiy", 1, 1);
        Address address2 = new Address("SPb", "Liteyniy", 1, 1);
        List<Profile> profiles = new ArrayList<>(
                Arrays.asList(
                        new Profile(address1),
                        new Profile(address2)
                )
        );
        List<Address> rsl = Profile.collect(profiles);
        List<Address> expected = Arrays.asList(address1, address2);
        assertThat(rsl, is(expected));
    }
}