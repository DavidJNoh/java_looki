package com.David.Lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.David.Lookify.models.Song;
import com.David.Lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository repo;
	
	public SongService(SongRepository repo) {
		this.repo = repo;
	}
	
	public List<Song> allSongs(){
		return repo.findAll();
	}
	
	public Song createSong(Song s) {
		return repo.save(s);
	}
	
	public Song findSong(Long id) {
		Optional<Song> maybe = repo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}
		else {
			return null;
		}
	}
	
	public void deleteSong (Long id) {
		repo.deleteById(id);
	}
	
	public List<Song> findByArtist(String name){
		return repo.findByArtist(name);
	}
	
	public List<Song> findTop10(){
		return repo.findTop10ByOrderByRatingDesc();
	}
}
