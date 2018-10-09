package com.David.Lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.David.Lookify.models.Song;
import com.David.Lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@RequestMapping("/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@RequestMapping(value = "/new", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song newSong, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			songService.createSong(newSong);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/song/{id}")
	public String oneSong(Model model, @PathVariable("id") Long id) {
		Song x = songService.findSong(id);
		model.addAttribute("name", x.getName());
		model.addAttribute("artist", x.getArtist());
		model.addAttribute("rating", x.getRating());
		model.addAttribute("id", x.getId());
		
		return "oneSong.jsp";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String destroy(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String destroy(@PathVariable("id") String id) {
		Long id1 = Long.valueOf(id);
		songService.deleteSong(id1);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchRedirect(@RequestParam("artist") String name) {
		return "redirect:/search/"+name;
	}
	
	@RequestMapping("/search/{name}")
	public String search(Model model, @PathVariable("name") String artist) {
		System.out.println(artist);
		System.out.println("###########");
		List<Song> songs = songService.findByArtist(artist);
		model.addAttribute("songs", songs);
		return "search.jsp";
	}
	
	@RequestMapping("/top")
	public String topTen(Model model) {
		List<Song> songs = songService.findTop10();
		model.addAttribute("songs", songs);
		return "topTen.jsp";
	}
	
}
