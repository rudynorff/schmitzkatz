When I first got this message I was looking for the issue in my code. After 15 minutes of making sure this was not the case I searched the web and quickly found an answer. If you ever run into this issue make sure that a directory called /var/lock exists and that it has proper permissions set.

	sudo mkdir /var/lock
	sudo chmod a+rw /var/lock

I found the solution on [Stackoverflow: RXTX on Mac - Serial port already in use](http://stackoverflow.com/questions/12866572/rxtx-on-mac-serial-port-already-in-use).