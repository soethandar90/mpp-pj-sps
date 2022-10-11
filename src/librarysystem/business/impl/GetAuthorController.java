package librarysystem.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import librarysystem.business.usecase.GetAuthorUseCase;
import librarysystem.dataaccess.DataAccess;
import librarysystem.dataaccess.DataAccessFacade;
import librarysystem.domain.Author;

public class GetAuthorController implements GetAuthorUseCase {
	GetAuthorController() {
	}

	@Override
	public List<Author> getAllAuthors() {
		
		DataAccess da = new DataAccessFacade();
		HashMap<String,Author> authors = da.readAuthorMap();
		if (authors==null) return null;
		return new ArrayList<>(authors.values());
	}
}
