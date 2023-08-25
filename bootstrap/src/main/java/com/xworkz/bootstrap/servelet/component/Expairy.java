package com.xworkz.bootstrap.servelet.component;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.ui.Model;

public class Expairy {

	public static void main(String[] args) {
		Instant targetTime = Instant.now().plus(Duration.ofMinutes(5)); // Set your target time here
		long remainingTimeMillis;

		while ((remainingTimeMillis = Duration.between(Instant.now(), targetTime).toMillis()) > 0) {
			long minutes = (remainingTimeMillis / (1000 * 60)) % 60;
			long seconds = (remainingTimeMillis / 1000) % 60;

			System.out.printf("Time remaining: %02d:%02d%n", minutes, seconds);

			try {
				Thread.sleep(1000); // Sleep for 1 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Countdown finished!");

	}
}
