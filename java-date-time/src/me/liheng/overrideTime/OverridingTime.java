package me.liheng.overrideTime;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class OverridingTime {

    public static void main(String[] args) {

        Clock clock = Clock.fixed(
                Instant.parse("2018-08-22T10:00:00Z"),
                ZoneOffset.UTC);

        System.out.println(LocalDateTime.now(clock));

    }
}
