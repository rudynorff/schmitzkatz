## What is it?

Schmitzkatz is a static blog-engine meaning that you don't need a webserver with a dynamic language like PHP or a database. All blog-posts are written on your computer and once finished can be generated to proper websites by Schmitzkatz. All that needs to be done then is to upload the pages to ones webserver.

The blog at http://mactun.es is powered by Schmitzkatz.

Blog posts are written in the Markdown format, meta data can be added to a simple JSON-file.


## Why?

As mentioned in the summary there are lots of blog-engines out there already. The static ones often require some form of setup in order to have a specific version 


## Requirements

A PC and a Java Runtime 1.6 or greater should be sufficient.


## How do I run it?

If you are brave enough you can create your own blog by running

	java -jar schmitzkatz-1.0-SNAPSHOT-distribution.jar -new "My first blog title"

This will create a new directory in blog/Posts with the name my-first-blog-title. To edit the meta-data of your new post open blog_post.json inside my-first-blog-title (usually you don't need to edit anything in there). To edit the posts text open blog_post.md and fire away. When you are done Schmitzkatz's generate-command will take all templates from blog/Templates and inject your blogpost into them. Run the following command to achieve this:

	java -jar schmitzkatz-1.0-SNAPSHOT-distribution.jar -generate

This will create all necessary HTML inside blog/Generated. Just upload the files to your webserver and you're done!

## How do I customize it?

Edit the templates in blog/Templates. The syntax inside is based on Freemarker.

## Disclaimer

This blog-engine is far from being complete. In fact I recommend you not to use it at the moment because it is way too unstable. I will be refactoring the project soon and hopefully find time to add some new features.

On my wishlist:

* Pagination
* Archiving of blog entries
* Fixing the existing bugs

**Update (2013-04-08)**: Fixed a lot of mobile CSS for this site.
