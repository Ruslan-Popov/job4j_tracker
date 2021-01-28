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
        Address address1 = new Address("Bryansk", "Nevskiy", 1, 1);
        Address address2 = new Address("Anapa", "Arbat", 1, 1);
        Address address3 = new Address("Vologda", "Sadovaya", 1, 1);
        List<Profile> profiles = new ArrayList<>(
                Arrays.asList(
                        new Profile(address1),
                        new Profile(address2),
                        new Profile(address3)
                )
        );
        List<Address> rsl = Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(address2, address1, address3);
        assertThat(rsl, is(expected));
    }
}