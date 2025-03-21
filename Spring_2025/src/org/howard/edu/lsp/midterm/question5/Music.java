package org.howard.edu.lsp.midterm.question5;

public class Music implements Streamable {
	private String title;
	
	public Music(String title) {
		this.title = title;
	}

	@Override
	public void play() {
		System.out.println("Playing music: " + title);
		
	}

	@Override
	public void pause() {
		System.out.println("Paused music: " + title);
		
	}

	@Override
	public void stop() {
		System.out.println("Stopped music: " + title);
		
	}
	
	/**
	 * This method adds a Music object to a playlist
	 * 
	 * @param playlistName is the name of the playlist
	 */
	public void addToPlaylist(String playlistName) {
		System.out.println("Added " + title + " to " + playlistName + " playlist.");
	}
	
}
