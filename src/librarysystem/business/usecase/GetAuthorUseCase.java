package librarysystem.business.usecase;

import java.util.List;

import librarysystem.domain.Author;

public interface GetAuthorUseCase {
	
	public List<Author> getAllAuthors();
}
