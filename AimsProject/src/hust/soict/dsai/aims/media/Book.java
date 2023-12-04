package hust.soict.dsai.aims.media;
import java.util.*;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public Book() {
		
	}
	public Book(String title) {
		this.title = title;
	}

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	
	// add author
	public boolean addAuthor(String authorName) {
        if(authors.contains(authorName)){
            return false;
        } else {
            authors.add(authorName);
            return true;
        }
    }
	
	//remove author
    public boolean removeAuthor(String authorName) {
        if(authors.contains(authorName)){
            authors.remove(authorName);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString(){
        StringBuffer printBook = new StringBuffer();
        printBook.append(id);
        printBook.append(" - ");
        printBook.append("Book");
        printBook.append(" - ");
        printBook.append(title);
        printBook.append(" - ");
        printBook.append(category);
        printBook.append(": ");
        printBook.append(cost);
        printBook.append(" $");
        return  printBook.toString();
    }

    @Override
    public boolean isMatch(String title){
    	System.out.println(title);
        return this.title.equals(title);
    }
}
