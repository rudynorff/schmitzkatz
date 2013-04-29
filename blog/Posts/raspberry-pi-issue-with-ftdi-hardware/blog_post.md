Disclaimer: I didn't come up with a fix to this issue. I rather wrote it down so that it can be found by others more easily.

Lately, I have been hacking around with a Raspberry Pi writing a small Java app which uses the RXTX library to read from a RS-232/USB adapter and sending the input via the Pi's ethernet port to a server for further processing. This worked reasonably well till one day I could not reach the Pi via SSH anymore. At first I thought of a random lockup, but after some days the issue kept repeating itself.

After looking through the logs something interesting caught my attention: /var/logs/messages showed hundreds of write errors via en0 (the ethernet interface). Below is a small excerpt from the log:


	Apr 29 19:59:57 raspberrypi kernel: [79225.020169] smsc95xx 1-1.1:1.0: eth0: Failed to write HW_CFG_LRST_ bit in HW_CFG register, ret = -110
	Apr 29 20:00:03 raspberrypi kernel: [79231.020288] smsc95xx 1-1.1:1.0: eth0: Failed to write register index 0x00000014
	Apr 29 20:00:03 raspberrypi kernel: [79231.020319] smsc95xx 1-1.1:1.0: eth0: Failed to write HW_CFG_LRST_ bit in HW_CFG register, ret = -110
	Apr 29 20:00:09 raspberrypi kernel: [79237.020457] smsc95xx 1-1.1:1.0: eth0: Failed to write register index 0x00000014
	Apr 29 20:00:09 raspberrypi kernel: [79237.020488] smsc95xx 1-1.1:1.0: eth0: Failed to write HW_CFG_LRST_ bit in HW_CFG register, ret = -110
	Apr 29 20:00:15 raspberrypi kernel: [79243.020614] smsc95xx 1-1.1:1.0: eth0: Failed to write register index 0x00000014
	Apr 29 20:00:15 raspberrypi kernel: [79243.020646] smsc95xx 1-1.1:1.0: eth0: Failed to write HW_CFG_LRST_ bit in HW_CFG register, ret = -110
	Apr 29 20:00:21 raspberrypi kernel: [79249.020764] smsc95xx 1-1.1:1.0: eth0: Failed to write register index 0x00000014
	Apr 29 20:00:21 raspberrypi kernel: [79249.020795] smsc95xx 1-1.1:1.0: eth0: Failed to write HW_CFG_LRST_ bit in HW_CFG register, ret = -110


After some websearches I found a lot of posts by others linked to the same issue and learned that the chipset on the Pi serves the USB port and the ethernet port and was probably disturbed by the FTDI driver (a driver for the chipset used powering lot of the RS-232/USB adapters out there).

After some time I found the solution to my troubles provided by some brilliant folks out there. The solution is to update the device's firmware/kernel to a more recent version where the bug has been resolved. This can be done easily via the tool [rpi-update](https://github.com/Hexxeh/rpi-update). To install and run it all you have to do is install git, get the script and run it:

	sudo apt-get install git-core
	sudo wget http://goo.gl/1BOfJ -O /usr/bin/rpi-update && sudo chmod +x /usr/bin/rpi-update
	sudo rpi-update

After these steps reboot the Raspberry. That should be all! Your system shouldn't lock up anymore. Hope this helps you as much as it helped me!

