# Subsystem Spec
## An Overview
This document serves to explain the basic functionally of each subsytem.   


This document is not by any means complete. It is being iterated and revised until perfect. The actual descriptions will update overtime as robot design decisions (both mechanically and programmatically) are made. 

This does not describe how each subsystem internally algorithms work. That will be done in a different location. It simplly discusses what each subsystem is meant to do, it's states are, and what mechanical motors/pneumatics/sensors it has.

*Marketing Note:* Make sure to highlight the fact that we use state-based programming. 

## Author
Carl Lee Landskron

## Resources
[WPILIB Subsystems](https://docs.wpilib.org/en/stable/docs/software/commandbased/subsystems.html)



## Scenarios
When understanding the importance of subsystems, it's good to consider two examples.

*Managerial Note* Yes, these Scenarios are fun, but how helpful are they really? Are they too abstract? Probably. 

Scenario 1: Jeff.

Jeff is creating a robot to fly to Jacksonville and back. This robot will have two sparkle adjusters, each moving in the same direction and power in order to prevent damage to the jetpack model. Thus, Jeff creates a subsystem to encapsolate the two sparkle adjuster objects in code. He then creates a method called *setSparkleAdjusters(double power)* that automatically sets the power to both sparkle adjusters to the same value. He then sets the sparkle adjuster objects to private so they never get set to different values.

Scenario 2: Timonthy.

Timothy hates baths, so he builds a robot to take his baths for him. This robot has two states, scubb-a-dubb-dubbing and crying tears of pain (from soap in its eyes). When scrubb state is active, the method *armFlailing(boolean isFlailing))* is passed false. When in a crying state, the method *armFlailing(boolean isFlailing))* is set to true. Timothy uses a subsystem class because he knows that these two states can't run at the same time, thus preventing rapid switching between flailing arms and non-flailing arms.

## Non-goals
For this project, we aren't going to worry about putting vision directly into the subsystems. Normally this would be something that would be put in the FRC 1646 libraries, but since those don't exist yet, we aren't going to worry about it.

We are not going add logging yet to the *periodic()* functions of each subsystem.




# Drivetrain
The drivetrain's job is to get the robot from point A to B, whether that be by driver input or trajectory following. It uses curvature drive and motion-profiling with quintic spline generation.

*Marketing Note:* Motion profiling + Curvature drive are very advance topics, please make sure include highlight them in any media about the drivetrain.

## States
### Open Loop (default)
In this state, the driver is in full control of movement. Joystick input will be fed directly in as power inputs to the motors (after being cubed in order to give more control to the drivers)
### Path Following
In this state, the motion is controlled by a trajectory. This trajectory is fed in as a parameter. It sets the speed of the drivetrain based on an internal timer. This state automatically ends when the timer reaches or exceeds the total time of the trajectory.
## Hardware
* 6 FalconFX's for driving

# Shooter
The shooter's job is to automatically track the goal and shoot balls when told to by the operator. It automatically tracks with the use of vision processing and gyro-based control. 

*Open Issue:* The shooter and hopper are very closely intertwined in function. We may need to consider combining into one subsystem. It might also be possible to push a "status" to smartdashboard and then pull it down to another subsystem, allowing it to "peek" at anothers status without causing issues.



## States
### Idle
All motors stop rotating.
### Lazy Tracking (default)
In this state, the turret uses the NavX Gyro to approximate the goal target. It uses the angle to point the turrent down field. This makes it so the turret is almost lined up once we are ready to shoot. All other motors stop spinning.
    
*Techinical Note:* Consider using occasional burst of limelight tracking to adjust the angle of hood. Might also make since not to move the hood (because that's you're like to shoot from the same position) or to go back to a default angle.

### Precision Shot
In this state, the turret and the hood use the limelight vision tracking to move into position. If an adeqauite vision target cannot be found, default to joystick values. The flywheels spin up once into position (within a tolerance). The limelight camMode is set to 1 for short range shooting.

*Techincal Note:* Rather than a 1, you could make a constant in the constances file and pull that.

### Long Shot
This state is the same as Precision Shot, except the Limelight camMode is set to 0.

### Quick Shot
This state is the same as Precision Shot, except the flywheel start spinning up immediate, allowing a operator to take a shot regardless of whether the turret is fully lined up. It will still try to lineup though.

*Techincal note:* Consider overloading and making this take in a tolerance parameter. The robot shoots once within the tolerance. Send a warning print statement if a tolerance less than the one specified by Precision Shot is used, since this method specifically is meant to be less tolerance than Precision Shot.

### Eject
This state sets the flywheels to a very low power, so the balls can be gentle lofted to forwards, about 10 feet. All other motors stop. Overload the construct to allow an turret angle and hood angle to be added to specify the position of these.

*Marketing Note:* This method is used not only for dejamming balls stuck in the shooter, but also for the strategic value of being able to unload one's feederstation very quickly into their trench run.


## Hardware
* 2 FalconFX's for the flywheels
* 1 TalonSRX for the hood
* 1 Rev through bore encoder for the hood
* 1 Limelight for hood and turret
* 1 TalonSRX for the turret
* 1 NavGyro for the turret

# Intake
The intake's job is to collect balls from the ground.

## States
### Idle (default)
In this state, the intake rollers stop spinning. It is stowed inside the robot for protection.
### Collecting
The intake roller spin inward. It is extended outside the frame to collect balls.

## Hardware
*Open Issue* Don't know what CAD plans to use to actuate intake
* 1 VictorSP for intake rollers
* 2 pneumatics for acuating the intake

# Hopper
The hopper's job is to store balls collected from the intake, then quickly push them into the shooter one by one.

## States
### Idle (default)
In this state, the dejammer wheels and the feeder wheels stop spinning.
### Feed
When entering the feed state, the dejammer wheels and the feeder wheels both spin inwards. This forces the balls into the shooter.
### Dejam
The feeder wheel stops spinning and the dejammer wheels spin outwards. This removes jams. All jellies, perservatives, and marmolades remain in the robot.

## Hardware
* 1 VictorSP for feeding balls
* 1 VictorSP (connected to 2 bag motors) to dejam balls

# Climber
The climber's job is to extend at the end of the match and allow the robot to pull itself up onto the shield generator.

## States
*Open Issue:* A clear enough picture does not exist. Talk to CAD about what theclimber might look like.

## Hardware
*Open Issue:* This is just a guess, because CAD has not designed this feature yet.
* 1 Falcon500 for climbing wench
* 1 pnuematic for a brake




# Writing Specs
Specs written based on approach by Joel Spolsky.

[Painless Functional Specifications](https://www.joelonsoftware.com/2000/10/02/painless-functional-specifications-part-1-why-bother/)

[A Practical Guide to Writing Techincal Specs](https://stackoverflow.blog/2020/04/06/a-practical-guide-to-writing-technical-specs/)

[Markdown and Visual Code Docs](https://code.visualstudio.com/docs/languages/markdown)

[Markdown Cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#links)
