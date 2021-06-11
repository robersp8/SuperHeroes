package com.robertorsp.crud;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.robertorsp.crud.controllers.SuperHeroeController;
import com.robertorsp.crud.entities.SuperHeroe;
import com.robertorsp.crud.repositories.SuperHeroeRepository;

public class UserControllerUnitTest {

	private static SuperHeroeController superHeroeController;
	private static SuperHeroeRepository mockedUserRepository;
	private static BindingResult mockedBindingResult;
	private static Model mockedModel;

	@BeforeClass
	public static void setUpUserControllerInstance() {
		mockedUserRepository = mock(SuperHeroeRepository.class);
		mockedBindingResult = mock(BindingResult.class);
		mockedModel = mock(Model.class);
		superHeroeController = new SuperHeroeController(mockedUserRepository);
	}

	@Test
	public void whenCalledIndex_thenCorrect() {
		assertThat(superHeroeController.showUserList(mockedModel)).isEqualTo("index");
	}

	@Test
	public void whenCalledshowSignUpForm_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		assertThat(superHeroeController.showSignUpForm(user)).isEqualTo("add-user");
	}

	@Test
	public void whenCalledaddUserAndValidUser_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		when(mockedBindingResult.hasErrors()).thenReturn(false);

		assertThat(superHeroeController.addUser(user, mockedBindingResult, mockedModel)).isEqualTo("redirect:/index");
	}

	@Test
	public void whenCalledaddUserAndInValidUser_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		when(mockedBindingResult.hasErrors()).thenReturn(true);

		assertThat(superHeroeController.addUser(user, mockedBindingResult, mockedModel)).isEqualTo("add-user");
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
		assertThat(superHeroeController.showUpdateForm(0, mockedModel)).isEqualTo("update-user");
	}

	@Test
	public void whenCalledupdateUserAndValidUser_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		when(mockedBindingResult.hasErrors()).thenReturn(false);

		assertThat(superHeroeController.updateUser(1l, user, mockedBindingResult, mockedModel))
				.isEqualTo("redirect:/index");
	}

	@Test
	public void whenCalledupdateUserAndInValidUser_thenCorrect() {
		SuperHeroe user = new SuperHeroe("Spiderman", "Sentido aracnido");

		when(mockedBindingResult.hasErrors()).thenReturn(true);

		assertThat(superHeroeController.updateUser(1l, user, mockedBindingResult, mockedModel))
				.isEqualTo("update-user");
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenCalleddeleteUser_thenIllegalArgumentException() {
		assertThat(superHeroeController.deleteUser(1l, mockedModel)).isEqualTo("redirect:/index");
	}
}
