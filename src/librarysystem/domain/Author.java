package librarysystem.domain;

import java.io.Serializable;

final public class Author extends Person implements Serializable {

	private String authorId;
	private String bio;

	public String getBio() {
		return bio;
	}

	public String getAuthorId() {
		return authorId;
	}

	public Author(String authorId, String f, String l, String t, Address a, String bio) {
		super(f, l, t, a);
		this.authorId = authorId;
		this.bio = bio;
	}

	private static final long serialVersionUID = 7508481940058530471L;
}
