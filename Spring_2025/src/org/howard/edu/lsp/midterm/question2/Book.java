package org.howard.edu.lsp.midterm.question2;

public class Book {
	String title;
	String author;
	String isbn;
	int pYear;
	
	

	public Book(String title, String author, String isbn, int pYear) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.pYear = pYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getpYear() {
		return pYear;
	}

	public void setpYear(int pYear) {
		this.pYear = pYear;
	}
	
	/**
	 * This method takes an object and compares the author and ISBN if the passed object is a Book
	 * 
	 * @param b is the book object that the caller is being compared to
	 * @return True if the books have the same ISBN and author, and false otherwise
	 * @return False if object passes is not a Book object
	 */
	public boolean equals(Object obj) { // https://www.geeksforgeeks.org/overriding-equals-method-in-java/
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book other = (Book) obj;
        return (this.author.equals(other.author) && this.isbn.equals(other.isbn));
    }
	
	/**
	 * This method returns a String representation of 
	 */
	@Override
	public String toString() {
		return "Title: " + this.title + ", Author: " + this.author + ", ISBN: " + this.isbn + ", Year Published: " + this.pYear;
	}
	
}
