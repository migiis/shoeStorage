package com.example.ShoeStorag;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.ShoeStorag.domain.Shoe;
import com.example.ShoeStorag.domain.ShoeRepository;
import com.example.ShoeStorag.domain.Type;
import com.example.ShoeStorag.domain.TypeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShoeRepositoryTest {

	@Autowired
	private ShoeRepository repository;
	
	@Autowired
	private TypeRepository trepository;
	
	@Test
	public void findByNameShouldReturnShoe() {
		List<Shoe> shoes = repository.findByName("Jolt 3");
		
		assertThat(shoes).hasSize(1);
		assertThat(shoes.get(0).getSize()).isEqualTo("33");
	}
	
	@Test
	public void createNewShoe() {
		Shoe shoe = new Shoe("Jordan", "One Take II", "Child", "34", "68 €", trepository.findByTypename("Sneaker").get(0));
		repository.save(shoe);
		assertThat(shoe.getShoeid()).isNotNull();
	}
}
