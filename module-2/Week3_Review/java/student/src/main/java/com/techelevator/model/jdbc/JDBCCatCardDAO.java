package com.techelevator.model.jdbc;

import com.techelevator.model.CatCard;
import com.techelevator.model.CatCardDAO;
import com.techelevator.model.CatCardNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCCatCardDAO implements CatCardDAO {

	private JdbcTemplate jdbcTemplate;
	private Logger log = LoggerFactory.getLogger(getClass());

	public JDBCCatCardDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<CatCard> list() {
		List<CatCard> catCards = new ArrayList<>();
		String sqlListAllCards = "SELECT * FROM catcards";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlListAllCards);
		
		while(results.next()) {
			CatCard catCard = mapRowToCatCard(results);
			catCards.add(catCard);
			
		}
		return catCards;
	}

	@Override
	public CatCard get(long id) {
		CatCard catCard = null;
		String sqlGetCardById = "SELECT * FROM catcards WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCardById);
		
		if(results.next()) {
			catCard = mapRowToCatCard(results);
			
		} else {
			throw new CatCardNotFoundException();
		}
		return catCard;
	}

	@Override
    public boolean update(long cardId, CatCard changedCard) {
        String sql = "UPDATE catcards SET img_url = ?, fact = ?, caption = ? WHERE id = ? ";
        return jdbcTemplate.update(sql, changedCard.getImgUrl(), changedCard.getFact(), changedCard.getCaption(), cardId) == 1;
    }
    @Override
    public boolean delete(long id) {
        String sql = "DELETE FROM catcards WHERE id = ? ";
        return jdbcTemplate.update(sql, id) == 1;
    }
    @Override
    public boolean save(CatCard card) {
        String sql = "INSERT INTO catcards (id, img_url, fact, caption) VALUES (DEFAULT, ?, ?, ?)";
        return jdbcTemplate.update(sql,card.getImgUrl(),card.getFact(),card.getCaption()) == 1;
    }

	// helper methods

	private CatCard mapRowToCatCard(SqlRowSet results) {
		CatCard catCard = new CatCard();
		catCard.setId(results.getLong("id"));
		catCard.setImgUrl(results.getString("img_url"));
		catCard.setFact(results.getString("fact"));
		catCard.setCaption(results.getString("caption"));
		return catCard;
	}

}
