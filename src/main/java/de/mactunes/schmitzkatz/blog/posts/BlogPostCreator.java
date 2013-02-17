package de.mactunes.schmitzkatz.blog.posts;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Date;
import de.mactunes.schmitzkatz.BlogProperties;
import de.mactunes.schmitzkatz.blog.posts.BlogPost;




public class BlogPostCreator {

	public static final String MEDIA_DIR_NAME = "media";
	public static final String BLOG_ENTRY_FILENAME = "blog_post.json";
	public static final String BLOG_MARKDOWN_FILENAME = "blog_post.md";
	public static final String README_FILENAME = "readme.txt";

	private BlogProperties properties;

	


	public BlogPostCreator(BlogProperties properties) {
		this.properties = properties;
	}


	public void createPost(String title) {
		if (null == title) { // TODO check for special chars and remove
			System.out.println("Error: The post title must not be empty or contain special characters.");
			return;
		}

		String directoryName = createDirectoryNameFromTitle(title);
		String absolutePostPath = BlogPost.POSTS_PATH + File.separator + directoryName;
		if (!(new File(absolutePostPath).exists())) {
			createBlogPostDirectory(absolutePostPath, title, directoryName);
		} else {
			System.out.println("\nError: Blog post with same name already exists. Please choose another title!\n");
		}
	}





	private String createDirectoryNameFromTitle(String title) {
		title = title.toLowerCase();
		title = title.replaceAll(" ", "-");

		return title;
	}

	private void createBlogPostDirectory(String path, String postTitle, String identifier) {
		if (new File(path).mkdir()) {
			if (new File(path + File.separator + MEDIA_DIR_NAME).mkdir()) {
				try {
					writeBlogPostMetaFile(path + File.separator + BLOG_ENTRY_FILENAME, postTitle, identifier);
					writeBlogPostMarkdownFile(path + File.separator + BLOG_MARKDOWN_FILENAME);
					writeReadmeFile(path + File.separator + README_FILENAME);
					System.out.println("\nBlog post \"" + path + "\" successfully created.\n");
				} catch (IOException ioe) {
					System.out.println("\nError: Failed to create blog-entry file.\n");
				}
			} else {
				System.out.println("\nError: Failed to create media-directory in post.\n");
			}
		} else {
			System.out.println("\nError: Failed to create post-directory.\n");
		}
	}

	private void writeBlogPostMetaFile(String path, String postTitle, String identifier) throws IOException {
		BlogPost post = new BlogPost(
								postTitle, 
								"Write a short summary of your article here. Note that blogpage.uses.abstract in your settings.properties needs to be set to true, first.", 
								new Date(),
								identifier);


		FileWriter outFile = new FileWriter(path);
		PrintWriter out = new PrintWriter(outFile);
		out.println(post.getJSONRepresentation());
		out.close();
	}

	private void writeBlogPostMarkdownFile(String path) throws IOException {
		FileWriter outFile = new FileWriter(path);
		PrintWriter out = new PrintWriter(outFile);
		out.println("Write your blog text here in Markdown-format. Don\'t know Markdown? Read about it here: http://daringfireball.net/projects/markdown/syntax.");
		out.close();
	}

	private void writeReadmeFile(String filePath) throws IOException {
		FileWriter outFile = new FileWriter(filePath);
		PrintWriter out = new PrintWriter(outFile);

		out.println("This directory includes blog_post.json and a blog_post.md that both need to be edited " +
			"in order to write a blog-post. Date & time, the title and summary can be set in the JSON file. " +
			"The markdown-file resembles the blog-posts main-text. \n\n" +
			"Images can be added to the media-directory which must be referenced in the text-section in " +
			"blog_post.json. Please note that if you change the date in the JSON-file to not alter the " +
			"format of the date. It always needs to be \"yyyy-MM-dd hh:mm:ss\". If you want to change how " +
			"the date is displayed alter it in the template file directly instead.\n\n" + 
			"Further help and instructions can be found in blog_post.json.\n\n" +
			"Once the blog-postis written the blog can be generated for uploading to a webserver. " +
			"Running Schmitzkatz.jar without any arguments explains how this can be achieved.");

		out.close();
	}

}













