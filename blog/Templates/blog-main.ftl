<!doctype html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>norff.net - A page from and about Rudy Norff</title>
    <link rel="stylesheet" href="stylesheets/app.css">
	
	<script src="scripts/app.js"></script>
</head>

<body>

    <ul id="main-nav" data-dropdown-menu>
        <!--<li><a href="#">software</a></li>-->
        <li><a href="projects.html">projects</a></li>
        <li><a href="about.html">me</a></li>
        <li><a href="blog-main.html">blog</a></li>
        <li><a href="contact.html">contact</a></li>
        <li class="icon">
            <a href="javascript:void(0);" onclick="toggleMenu()">&#9776;</a>
        </li>
    </ul>

    <section id="main-section">
	  <h1>Blog</h1>
	  
      <#list blogposts as post>
        <article>
          <header>
            <h1><a href="${post.link}">${post.title}</a></h1>
            <span>${post.date?string("yyyy-MM-dd")}</span>
          </header>
          <section class="post-text">
            ${post.summary}
            <p>
              <a href="${post.link}">Read on...</a>
            </p>
          </section>
        </article>
      </#list>
    </section>
	
  </body>
</html>