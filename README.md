# 1646_InfiniteRecharge_Offseason
*Code Base for FRC Team 1646, Precision Guessworks*

This code is for the 2021 FRC Game, Game Changers. Due to the covid-19 outbreak of 2020, this is a replay of the 2020 game, infinite recharge.

# Resources
* [WPILIB Documentation](https://docs.wpilib.org/en/stable/)
* [WPILIB API](https://first.wpi.edu/FRC/roborio/release/docs/java/index.html)
* [CTRE Tech Documentation](http://www.ctr-electronics.com/talon-fx.html#product_tabs_technical_resources)
* [CTRE API](http://www.ctr-electronics.com/downloads/api/java/html/index.html)
* [Git Commit Standards](https://chris.beams.io/posts/git-commit/)

# Draft Installation Instructions

1. Prerequisites:
     * Git-Bash
     * Java 8 (need to check if this is the correct version)
     * WPI-Libraries for FRC
     * VS-Code

1. Fork Github repo. (https://guides.github.com/activities/forking/)

1. Create a folder called 'FRC1646Code' on your desktop. (If you are keeping your code in a different location, you will have to adjust the following commands accordingly)

1. Use Gitbash to navigate to the the 'FRC1646Code' Folder.
      
        $ cd Desktop/FRC1646Code
        
1. Clone the repo to your local machine. Make sure to insert you username in the url below.
      
        $ git clone https://github.com/[yourGitHubUsername]/GameChangers2020-2021.git
      
1. Using VS code, open the folder named 'GameChangers2020-2021' in your 'FRC1646Code' folder.

1. Navigate to the git file. Create a remote for your fork that allows you to sync changes made in the original repo with your fork. (For Mac/Linux, use terminal, for Windows use GitBash)

        $ cd /GameChangers2020-2021.git/
        $ git remote -v
        $ git remote add upstream https://github.com/PrecisionGuessworks/GameChangers2020-2021.git
        $ git remote -v

# Syncing Main Repo to Fork
These instructions are used to sync your fork to the main repo. Doing this may cause changes to your working version of your code, so it is discourage to do this unless you know what changed in the main repo or are specifically testing for compatibility. These instructions were pulled from the following github location: https://help.github.com/en/github/collaborating-with-issues-and-pull-requests/syncing-a-fork

1. Open GitBash (Windows) or Terminal (Mac/Linux). Change the current working directory to your local project.

1. Fetch the branches and their respective commits from the upstream repository. Commits to master will be stored in a local branch, upstream/master.

        $ git fetch upstream

1. Check out your fork's local master branch.

        $ git checkout master

1. Merge the changes from upstream/master into your local master branch. This brings your fork's master branch into sync with the upstream repository, without losing your local changes.

        $ git merge upstream/master

# Getting/Looking at Logs
These are used for making and accessing the logs for the shooter. 
1. Enable the Robot.

1. Use the shoooter, and let it slow down naturally before disabling. 

1. Disable the robot. 

1. Open GitBash. 

1. Type in the following commands
    
    $ cd ~/Desktop/logs
    
    $ scp lvuser@10.16.46.2:~/logs/* .
    
1. Open File explorer and open to Desktop. 

1. Open logs folder.

1. Open the csv file with the day's date. 

1. Click Insert --> Chart --> Line --> Finish
