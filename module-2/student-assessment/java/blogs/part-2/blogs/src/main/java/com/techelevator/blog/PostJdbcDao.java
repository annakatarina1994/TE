package com.techelevator.blog;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class PostJdbcDao implements PostDao {

	private JdbcTemplate jdbcTemplate;

	public PostJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Post newPost) {
		String sql = "INSERT INTO posts (id, name, body, published, created) "
				+ "VALUES (?, ?, ?, ?, ?)";
		
		newPost.setId(getNextPostId());
		
		jdbcTemplate.update(sql, newPost.getId(), newPost.getName(), newPost.getBody(), 
				newPost.isPublished(), newPost.getCreated());
	}

	@Override
	public List<Post> getAllPosts() {
		List<Post> allPosts = new ArrayList<>();
		String sql = "SELECT * FROM posts";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while(results.next()) {
			Post post = mapRowToPost(results);
			allPosts.add(post);
		}
		return allPosts;
	}

	private Post mapRowToPost(SqlRowSet results) {
		Post postRow = new Post();
		postRow.setId(results.getLong("id"));
		postRow.setName(results.getString("name"));
		postRow.setBody(results.getString("body"));
		postRow.setPublished(results.getBoolean("published"));
		postRow.setCreated(results.getDate("created").toLocalDate());
		return postRow;
	}
	
	private Long getNextPostId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('posts_id_seq')");
		
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		}
		throw new RuntimeException("Error in getNextPostId");
	}

}
