package edu.ucema.marketplace;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ucema.marketplace.config.Constants;
import edu.ucema.marketplace.controllers.CollectionController;
import edu.ucema.marketplace.models.Collection;

@SpringBootTest
class MarketplaceApplicationTests {

	@Autowired
	private CollectionController collectionController;

	@Test
	void contextLoads() {
	}

	@Test
	void testGetExistingCollection() {
		Collection collection = this.collectionController.getCollection(Constants.BORED_APE_COLLECTION.getAddress());
		assert collection.equals(Constants.BORED_APE_COLLECTION);
	}

	@Test
	void testGetNullCollection() {
		Collection collection = this.collectionController.getCollection("fakeAddress");
		assert collection == null;
	}

	@Test
	void testGetAllCollections() {
		assert this.collectionController.getAllCollections().size() == 3;
	} 

}
