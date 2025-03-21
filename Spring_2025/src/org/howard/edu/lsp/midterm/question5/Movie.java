package org.howard.edu.lsp.midterm.question5;

public class Movie implements Streamable{
	private String title;
	
	public Movie(String title) {
		this.title = title;
	}
	
	@Override
	public void play() {
		System.out.println("Playing movie: " + title);
		
	}

	@Override
	public void pause() {
		System.out.println("Paused movie: " + title);
		
	}

	@Override
	public void stop() {
		System.out.println("Stopped movie: " + title);
		
	}
	
	/**
     * Rewinds the movie by the specified number of minutes.
     *
     * @param minutes is the number of minutes to rewind
     */
    public void rewind(int minutes) {
        System.out.println("Rewinding movie: " + title + " by " + minutes + " minutes");
    }

}
