package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Blog;
import utility.ConnectionManager;

public class BlogDaoImpl{
	

	public void insertBlog(Blog blog) throws Exception
	{
		// TODO Auto-generated method stub
		Connection con=ConnectionManager.getConnection();
		String sql="INSERT INTO BLOGS(blogId,blogName,blogDescription) VALUES(?,?,?,?)";
		PreparedStatement st = ConnectionManager.getConnection().prepareStatement(sql);
		st.setLong(1, blog.getBlogId());
		st.setString(2,blog.getBlogTitle());
		st.setString(3,blog.getBlogDescription());
		st.executeUpdate();
		con.close();	
	}
	public Blog selectBlog(int blogId) throws Exception {
		Blog blog = null;
		System.out.println(blogId);
		Connection con = ConnectionManager.getConnection();
		String sql ="select blogId,blogname,blogDescription from blog where blogId ="+blogId;
		Statement  st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			int Id = rs.getInt("blogId");
			String blogTitle = rs.getString("blogName");
			String blogDescription = rs.getString("blogDescription");				
			blog = new Blog();
			blog.setBlogId(Id);
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(blogDescription);				
		}
		return blog;
	}
	public List<Blog> selectAllBlogs() throws Exception {
		Blog blog = null;
		List<Blog> blogList = new ArrayList<>();
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st = con.prepareStatement("select * from BLOGS");
		System.out.println(st);
		ResultSet rs = st.executeQuery();
		while (rs.next()) {
			int Id = rs.getInt("blogId");
			String blogTitle = rs.getString("blogName");
			String blogDescription = rs.getString("blogDescription");				
			blog = new Blog();
			blog.setBlogId(Id);
			blog.setBlogTitle(blogTitle);
			blog.setBlogDescription(blogDescription);
			blogList.add(blog);
		}
		return blogList;
	}
	public boolean deleteBlog(int id) throws Exception {
		boolean delete;
		Connection con = ConnectionManager.getConnection();
		PreparedStatement st = con.prepareStatement( "delete from blog where blogId = "+id);
		st.setInt(1, id);
		delete = st.executeUpdate()>0;
		return delete;
	}
	public boolean updateBlog(Blog blog) throws Exception {
		boolean updateCheck = false;
		
		Connection connection = ConnectionManager.getConnection();
		PreparedStatement statement = connection.prepareStatement("update blog set  blogName = ?, blogDescription = ?  where blogId = ?"); 
		statement.setString(1, blog.getBlogTitle());
		statement.setString(2,blog.getBlogDescription());
		statement.setInt(3, blog.getBlogId());
		
		updateCheck = statement.executeUpdate() > 0;
		System.out.println(updateCheck);
		return updateCheck;
	}
}