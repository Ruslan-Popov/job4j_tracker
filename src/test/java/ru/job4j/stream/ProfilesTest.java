package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {
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
        List<Address> rsl = Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(address1, address2);
        assertThat(rsl, is(expected));
    }
}