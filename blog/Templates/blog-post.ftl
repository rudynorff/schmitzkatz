<!doctype html>
<html lang="en" dir="ltr">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>norff.net - A page from and about Rudy Norff</title>
    <link rel="stylesheet" href="../../../../../stylesheets/app.css">
	
	<script src="../../../../../scripts/app.js"></script>
</head>

<body>

    <ul id="main-nav" data-dropdown-menu>
        <!--<li><a href="#">software</a></li>-->
        <li><a href="../../../../../projects.html">projects</a></li>
        <li><a href="../../../../../about.html">me</a></li>
        <li><a href="../../../../../blog-main.html">blog</a></li>
        <li><a href="../../../../../contact.html">contact</a></li>
        <li class="icon">
            <a href="javascript:void(0);" onclick="toggleMenu()">&#9776;</a>
        </li>
    </ul>

    <section id="main-section">
        
      <article>
        <header>
          <h1>${post.title}</h1>
          <span>${post.date?string("yyyy-MM-dd")}</span>
        </header>
        <a href="https://twitter.com/share" class="twitter-share-button" data-lang="en" data-text="${post.title}">Tweet</a>
        <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0];if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src="https://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
        <section class="summary-text">
          ${post.summary}
        </section>
        <section class="post-text">
		  ${post.textAsHTML}
        </section>
      </article>
	  
    </section>
  </body>
</html>