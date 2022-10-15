package spslibsys.businessLogic.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import spslibsys.businessLogic.ifusecase.GetAuthorUseCase;
import spslibsys.dataaccess.DataAccess;
import spslibsys.dataaccess.DataAccessFacade;
import syslibsys.dom.Author;

public class GetAuthorController implements GetAuthorUseCase {
	GetAuthorController() {
	}

	@Override
	public List<Author> getAllAuthors() {

		DataAccess da = new DataAccessFacade();
		HashMap<String, Author> authors = da.readAuthorMap();
		if (authors == null)
			return null;
		return new ArrayList<>(authors.values());
	}
}
