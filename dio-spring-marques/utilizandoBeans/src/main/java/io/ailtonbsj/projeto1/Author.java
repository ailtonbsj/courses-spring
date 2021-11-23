package io.ailtonbsj.projeto1;

public class Author implements AuthorBook {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + "]";
	}
	
	public void showAuthor() {
		System.out.println(this.toString());
	}
}
