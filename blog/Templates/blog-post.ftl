<!doctype html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<title>mactun.es</title>
		<link rel="stylesheet" media="screen" href="../../../../../stylesheets/desktop.css">
	</head>
	<body>
		<div id="container">
			<nav>
				<ul id="navigation">
					<li><a href="../../../../../apps.html" class="left-link">apps</a></li>
					<li><a href="../../../../../index.html" class="active left-link">blog</a></li>
					<li>
						<a href="http://mactun.es">
							<img src="../../../../../media/logo_compact.png" alt="mactun.es Logo" />
						</a>
					</li>
					<li><a href="../../../../../contact.html" class="right-link">contact</a></li>
					<li><a href="../../../../../about.html" class="right-link">about</a></li>
				</ul>
			</nav>

			<hr />

			<section>
				<article>
					<header>
						<h1><a href="#">${post.title}</a></h1>
						<span>${post.date?string("yyyy-MM-dd")}</span>
					</header>
					<section id="summary-text">
						${post.summary}
					</section>
					<section id="post-text">
						${post.textAsHTML}
					</section>
				</article>
			</section>
		</div>
	</body>
</html>