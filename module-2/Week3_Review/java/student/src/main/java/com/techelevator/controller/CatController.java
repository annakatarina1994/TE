package com.techelevator.controller;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/cards")
public class CatController {

    private CatCardDAO catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDAO catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }
    
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<CatCard> list(){
    	return catCardDao.list();
    }
    
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable long id) {
    	return catCardDao.get(id);
    }
    
    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard getRandom() {
    	CatCard card = new CatCard();
    	CatFact fact = catFactService.getFact();
    	CatPic pic = catPicService.getPic();
    	card.setFact(fact.getText()); // set the fact in the catcard by getting text from the model
    	card.setImgUrl(pic.getFile());
    	
    	return card;
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public void saveNewCard(@Valid @RequestBody CatCard newCard) {
    	catCardDao.save(newCard);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path ="/{id}", method = RequestMethod.PUT)
    public void updateCard(@Valid @PathVariable long id, @RequestBody CatCard updatedCard) {
    	catCardDao.update(id, updatedCard);
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
    	if(catCardDao.get(id) != null) {
    		catCardDao.delete(id);
    	}
    }
}

