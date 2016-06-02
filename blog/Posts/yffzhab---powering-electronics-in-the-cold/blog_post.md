# The setup
The picture below shows our setup. 

![YFFZHAB payload setup](media/box_layout.jpg)

We have the following items in it:

*	GPS Tracker, bought on eBay for 38 dollars. Ships with its own lithium-ion battery and is used for tracking.
*	GSM Tracker, bought on eBay for 20 dollars. Works as a backup if the GPS tracker fails. Comes with its own 
	lithium-polymer battery.
*	Raspberry Pi Model A+ and the Pi Camera module. Used for taking videos in the sky. You will find out which battery turned out to be suitable in this post.

This post will focus on finding a good battery that can handle cold temperatures and then show how to connect it to the Pi. I am still looking to replace the GPS/GSM trackers with a
self made solution, mainly due to the fact that if they die in the cold they don't automatically turn on again (if the battery comes back to life after warming up again). If we used an Arduino with a GSM modem and a GPS chip it should be way more reliable, as it automatically switches on after power is supplied. So maybe in a future post you can read more of this.

# Problems
Powering the Pi led us to two main problems:
1.	Battery drain in cold environments: this is especially bad as the Pi consumes a lot of amps
2.	Matching the Pi's input voltage of 5V: most batteries come in 1.2V, 1.5V and 9V


# Battery drain in cold environments
When we designed our first prototype that we wanted to send up to the stratosphere it was a cheap smartphone. We designed our own styrofoam box to isolate it from the down to -60 degrees celsius, but in order for the camera to point out we had to cut a hole in it. We did a test by putting the phone in the freezer and checking every ten minutes how things were. During the first test the phone didn't even last ten minutes. The second test was a little better, but it only lasted a little longer than ten minutes.

We were shocked. We expected the phone to not do well, but we didn't expect it to die in just ten minutes! So what happened? I turns out that most (if not all batteries) don't take low temperatures well. Especially, lithium-ion batteries found in most smartphones, laptops and other consumer electronics use them.

The more a battery is used the more of its voltage it loses. For example when you use a battery in your flashlight, the more you use that flash light (and the more amperes are used from it) the lower the voltage of that battery will go. Additionally, cold temparatures slow the chemical process in batteries and cause the voltage to further drop. By the way, as soon as the battery warms up the voltage also comes up again.

## Finding a suitable battery
For those who didn't read the last post, in Germany there is a 500g regulation. So balloon + payload + parachute must weigh less than 500 grams. Hence, I was interested in light-weight batteries and not in bundling 6 AA batteries together. Doing a bit of research I came across the Energizer Ultimate Lithium 9V block battery. This battery has around 1000mAh battery life, an operating temperature starting at -40 degrees Celsius(!) and a maximum operating current of 1 ampere and all this weighing in at just 34 grams! I looked further, but I couldn't find any alternatives (I even tried some other lithiums like the Conrad Lithium 9V block battery) that looked this good, hence the product placement :).

During some tests I noticed that the battery gets really warm when connecting the Raspberry Pi to it, which is another benefit when it's cold. I will hopefully warm up the inside of the box a bit. We will see if the battery is up for the challenge. 

Checking the batteries starting voltage I found out that it was at 10.7V(!) and it drops to around 7V under heavy load after around 20 minutes. Heaving a voltage range from 7V (and probably less at minus degrees) up to almost 11V, how do you actually run a Raspberry Pi that requires 5V input voltage? I didn't know either until I stumbled across the article "[Running the Raspberry Pi on batteries](http://www.daveakerman.com/?page_id=1294)".

## Voltage regulators
The thing that I took away from the article was that I needed a voltage regulator. Linear regulators produce heat and are not very efficient, switching regulators on the other hand are very efficient, but they can cause interference. After going back and forth a friend I made on the [GSBC](http://www.balloonchallenge.org) told me to give the Pololu regulators a try. Actually, they are DC-DC converters that can step down the voltage as well as step up the voltage! I decided for the [S7V7F5](https://www.pololu.com/product/2119) and it turns out to work just great for our needs!

With a bit of soldering this is how the finished S7V7F5 looks:
![Pololu S7V7F5 Switching Regulator](media/voltage_regulator.jpg)
We connected a battery clip on the other side so that the energizer block battery can be attached to the regulator and on the other side to the Raspberry Pi.
![Assembled S7V7F5 Switching Regulator](media/voltage_regulator_connected.jpg)
Important: connecting the regulator to your Raspberry Pi in a wrong way or to a wrong pin might break your equipment. We are no experts and not responsible for any damage that might happen. With the disclaimer befor, connect the positive connector to the upper right pin and the negative wire to the 3rd pin on the upper right. After connecting your battery your Raspberry Pi should start.

# Bottom Line
Using a lithium 9V block battery and a Pololu S7V7F5 DC/DC converter you are able to run the Raspberry Pi for several hours. We haven't tried the maximum time, but we have run five tests where we ran the Pi for 140 minutes and it worked like a charm. All this while recording 720p video. Our first balloon will start very soon so we should get some real-life test results back. So stay tuned. Next topic will be insulation or how to protect the payload from wind and cold temperature, because keeping the batteries warm is another solution to the problem.





