# APCS_FinalProject  <br />
BASKETBALL SIMULATOR 2K17  <br />
RUN TESTER TO PLAY GAME  <br />
RUN TESTER TO PLAY GAME  <br />
RUN TESTER TO PLAY GAME  <br />
RUN TESTER TO PLAY GAME  <br />
Mr. Young's APCS Class  <br />
William Xie, Eric Xue  <br />
Logo by Vellia Zhou: https://imgur.com/a/tLsVv   <br />
We didn't write CustomOutputStream, referenced from here:  <br />
http://www.codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea  <br />

Instructions:
Welcome to Basketball Simulator 2K17! <br />
By: William Xie and Eric Xue (Logo by Vellia Zhou)<br />
For: Mr. Young's AP Computer Science A Class<br />
Control the team through console input. You'll have to delete a lot of windows<br />
Enter '0' for more in-depth instructions. Minimize the console to fit ~4-5 lines.<br />
Excepting all the other times, at any point in time, enter a string into the console to return to the User Manual.<br />
Entering actions via console will open up new windows on the GUI. You'll end up with a lot of windows open.<br />
You could be cheeky and enter in Strings for ints or ints for Strings. Or you could not.<br />

Start a season and simulate games:<br />
The whole point of the game is to build a team through trades and drafts that play games in order to win a championship.<br />
We couldn't quite get the whole 'simulate playoffs' part working, but you can play in games and seasons!<br />
Before you simulate any games(Enter '2'), you have to start a season (Enter '1'). <br />
There are 82 games in a season. You can view the League rankings and Box Scores of the most recent 15 games.<br />
There are some bugs regarding playing all 82 games and then initiating the next draft. Oh well.<br />

Trades: you can trade players between teams.<br />
Until 60 games into the season and while the season is over, you may trade players (Enter '3'). This is the trade deadline.<br />
Trades are proposed by you and can be between any two teams (not necessarily you and another team).<br />
Players have generated PlayerValues (and hidden, modified TradeValues)<br />
These determine their 0-99 attributes, roster stats, and team trades.<br />
Teams reject trades if the sum of squares of the offered Players' TradeValues is +-2000 than the other team's sum.<br />
As a client, you will not be forced to reject, but will be encouraged not to accept if given a poor offer.<br />
If a proposed trade is valid, you will have the chance to view the composite TradeValues and execute the trade or not.<br />

View Teams and Players:<br />
To view the 0-99 attributes and PlayerValues of each team, Enter '4' to see teams, Enter '1'-'30' to view a team.<br />
To view the roster stats of each team in a season (Enter '5' to see all teams), enter '1' through '30' to view a team.<br />
Team order will changes frequently. Be very aware! This is due to static variables/bad program design.<br />
Players gain PlayerValue years 0-5. If lucky (you can't know this) they'll improve a little, a lot, or really a lot in year 6.<br />
PlayerValues don't change years 7-12, and decrease years 12-19. They immediately retire after year 19 (age 40).<br />

PlayerPool: a collection of free agent players.<br />
You, the player, will be able to view PlayerPool and cut/sign players whenever you want.<br />
You will be forced to cut/sign players from the pool if you have less/more than 12 players.<br />
If you want to remove a player on your team, enter '6'. If you want to sign a player from the pool, enter '7'.<br />
Unlike other actions, when forced to cut players, team actions will output information to console, not a window.<br />
For some reason I can't figure out, you have to press '1' 30 times to automate cutting for 30 teams.<br />

Draft: " +
After a season ends, a draft of 60 new players occurs. Depending on league rankings, you pick at two certain points.<br />
As will be told to you, mock draft rankings (done by PlayerValues) for those 60 players and the team pick order are shown.<br />
AI teams will pick in that order, you don't have to. Players are ranked by PlayerValue, but have different 0-99 stats.<br />
PlayerValues improve by a hidden amount each year. Don't be immediately dissuaded by a low PlayerValue<br />
If you exit a draft mid-pick or decline to immediately begin the draft, Enter '8' to resume the draft from where you were.<br />

Exit:<br />
Enter '9' to terminate the game. Your data won't be saved, but the dozens of windows cluttering your screen will close.<br />

Miscellaneous facts and features that weren't implemented: <br />
We implemented a merge search (aka Collections.sort()) to get rankings/draft orders.<br />
It works but it's why viewing teams is messed up.<br />
Some things we meant to do that completely failed/needed more time: random name generation, live game viewing <br />
(i.e. game generation possession by possession), salary caps, trading DraftPicks, on-window user input <br />
Thanks to Vellia Zhou for creating our awesome logo!! Also thanks to Mr. Young for being the only reason I go to school. <br />
