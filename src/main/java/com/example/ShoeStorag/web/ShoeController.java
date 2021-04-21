package com.example.ShoeStorag.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ShoeStorag.domain.Shoe;
import com.example.ShoeStorag.domain.ShoeRepository;
import com.example.ShoeStorag.domain.TypeRepository;
import com.example.ShoeStorag.domain.User;
import com.example.ShoeStorag.domain.UserRepository;

@Controller
public class ShoeController {
	
	@Autowired
	private ShoeRepository repository;
	
	@Autowired
	private TypeRepository trepository;
	
	@Autowired
	private UserRepository urepository;
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
	@RequestMapping(value={/*"/",*/ "/shoestorage"})
	public String shoeStorage(Model model) {
		
		/*UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		User userNow = urepository.findByUsername(username);
		model.addAttribute("shoes", repository.findByUser(userNow));*/
		
		model.addAttribute("shoes", repository.findAll());
		return "shoestorage";
	}
	
	@RequestMapping(value= "/shoes", method = RequestMethod.GET)
	public @ResponseBody List<Shoe> shoeStorageRest() {
		return (List<Shoe>) repository.findAll();
	}
	
	@RequestMapping(value= "/shoe/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Shoe> findShoeRest(@PathVariable("id") Long shoeId) {
		return repository.findById(shoeId);
	}
	
	@RequestMapping(value= "/add")
	public String addShoe(Model model) {
		model.addAttribute("shoe", new Shoe());
		model.addAttribute("types", trepository.findAll());
		return "addshoe";
	}
	
	@RequestMapping(value= "/save", method = RequestMethod.POST)
	public String save(Shoe shoe) {
		repository.save(shoe);
		return "redirect:shoestorage";
	}
	
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteShoe(@PathVariable("id") Long shoeId, Model model) {
		repository.deleteById(shoeId);
		return "redirect:/shoestorage";
	}
	
	@RequestMapping(value= "/edit/{id}", method = RequestMethod.GET)
	public String modifyShoe(@PathVariable("id") Long shoeId, Model model) {
		Optional<Shoe> shoe = repository.findById(shoeId);
		model.addAttribute("shoe", shoe);
		model.addAttribute("types", trepository.findAll());
		return "modifyshoe";
	}
}
