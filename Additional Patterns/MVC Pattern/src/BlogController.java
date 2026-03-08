import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogController {
    private final List<Blog> blogs; // acts as an in-memory database
    private final BlogView view;
    public BlogController(BlogView view) {
        this.view = view;
        this.blogs = new ArrayList<>();
        }
        // Add a new blog post
        public void addBlog(String title, String content, String author) {
        Blog blog = new Blog(title, content, author, new Date());
        blogs.add(blog);
        System.out.println("[+] Blog added successfully!");
        }

        // Update an existing blog by index
        public void updateBlog(int index, String newTitle, String
            newContent) {
        if (index >= 0 && index < blogs.size()) {
            Blog blog = blogs.get(index);
            blog.setTitle(newTitle);
            blog.setContent(newContent);
            System.out.println("[+] Blog updated successfully!");
            } else {
            System.out.println("[+] Invalid blog index!");
            }
        }

        // Delete a blog post
        public void deleteBlog(int index) {
        if (index >= 0 && index < blogs.size()) {
            Blog removed = blogs.remove(index);
            System.out.println("[+] Blog deleted successfully!");
            } else {
            System.out.println("[+] Invalid blog index!");
            }
        }

        // Display a single blog post
        public void showBlog(int index) {
        if (index >= 0 && index < blogs.size()) {
            view.displayBlogDetails(blogs.get(index));
            } else {
            System.out.println("[+] Invalid blog index!");
            }
        }

        // Display all blogs
        public void showAllBlogs() {
        view.displayAllBlogs(blogs);
        }
}
