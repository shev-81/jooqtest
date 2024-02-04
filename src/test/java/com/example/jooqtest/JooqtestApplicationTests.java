package com.example.jooqtest;

import com.example.jooqtest.configurations.DataSourceConfig;

import org.jooq.DSLContext;
import org.jooq.exception.TooManyRowsException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static com.example.jooqtest.domain.tables.Categories.CATEGORIES;
import static com.example.jooqtest.domain.tables.Products.PRODUCTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Import(DataSourceConfig.class)
public class JooqtestApplicationTests {


	@Autowired
	DSLContext dslContext;


	@Test
	public void loadsTest() {
		var result = dslContext.select(PRODUCTS.ID, PRODUCTS.NAME)
				.from(PRODUCTS)
				.fetch();
		result.forEach(record -> {
			System.out.println(record.getValue(PRODUCTS.ID));
			System.out.println(record.getValue(PRODUCTS.NAME));
		});
		assertTrue(true);
	}


	@Test
	public void selectJoinTest() {
		var result = dslContext.select(CATEGORIES.NAME, PRODUCTS.NAME)
				.from(PRODUCTS)
				.join(CATEGORIES)
				.on(PRODUCTS.CATEGORY_ID.eq(CATEGORIES.ID))
				.where(PRODUCTS.NAME.eq("CPU-1").and(CATEGORIES.ID.eq(1L)))
				.fetch();
		if(result.isEmpty()){
			System.out.print("CATEGORIES.NAME + PRODUCTS.NAME = null");
		}
		assertTrue(result.isEmpty());
	}


	@Test
	public void newRecordTest() {

		var categoriesRecord = dslContext.newRecord(CATEGORIES);
		categoriesRecord.setName("Одежда");
		int countRecord = categoriesRecord.store();
		assertTrue(1 <= countRecord);

		var result = dslContext.select()
				.from(CATEGORIES)
				.where(CATEGORIES.NAME.eq("Одежда"))
				.fetch(CATEGORIES.NAME);


		assertEquals("Одежда", result.stream().findFirst().get());
	}


	@Test
	public void distinctResultTest() {

		var result = dslContext.select(CATEGORIES.NAME, PRODUCTS.NAME)
				.from(CATEGORIES)
				.join(PRODUCTS)
				.on(CATEGORIES.ID.eq(PRODUCTS.CATEGORY_ID))
				.where(PRODUCTS.NAME.eq("CPU"))
				.fetch();


		result.stream().findFirst().ifPresent(record -> {
			assertEquals("Technics", record.value1());
			assertEquals("CPU", record.value2());
		});

		var singleResult = dslContext.fetchOptional(PRODUCTS, PRODUCTS.NAME.eq("CPU"));
		assertTrue(singleResult.isPresent());
	}


	@Test(expected = TooManyRowsException.class)
	public void distinctResultFromCollectionTest() {

		var singleResult = dslContext.fetchOptional(CATEGORIES, CATEGORIES.NAME.eq("Одежда"));
		assertTrue(singleResult.isPresent());
	}


}
