package com.robertorsp.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.robertorsp.crud.entities.SuperHeroe;

public class UserUnitTest {

	@Test
	public void whenCalledGetName_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		assertThat(user.getName()).isEqualTo("Spiderman");
	}

	@Test
	public void whenCalledGetSuperpower_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		assertThat(user.getSuperpower()).isEqualTo("Sentido aracnido");
	}

	@Test
	public void whenCalledSetName_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		user.setName("Superman");

		assertThat(user.getName()).isEqualTo("Superman");
	}

	@Test
	public void whenCalledSetSuperpower_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		user.setSuperpower("Volar");

		assertThat(user.getSuperpower()).isEqualTo("Volar");
	}

	@Test
	public void whenCalledtoString_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");
		assertThat(user.toString()).isEqualTo("User{id=0, name=Spiderman, superpower=Sentido aracnido}");
	}
}
