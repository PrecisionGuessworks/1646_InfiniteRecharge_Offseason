/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drivetrain.states;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;


public class PathFollowerState extends CommandBase {
  
  DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();
  Trajectory trajectory;
  Timer path_timer;

  public PathFollowerState(Trajectory trajectory) {
    path_timer = new Timer();
    this.trajectory = trajectory;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    path_timer.start();
  }

  @Override
  public void execute() {
    double current_time = path_timer.get();

    double velocity = trajectory.sample(current_time).velocityMetersPerSecond;
    double angularVelocity = velocity * trajectory.sample(current_time).curvatureRadPerMeter;

    double accel = trajectory.sample(current_time).accelerationMetersPerSecondSq;
    double angularAccel = accel * trajectory.sample(current_time).curvatureRadPerMeter;

    double leftVelocity = velocity + angularVelocity;
    double rightVelocity = velocity - angularVelocity;
    
    drive.setSpeed(leftVelocity, rightVelocity);
  }

  @Override
  public boolean isFinished() {
    return path_timer.hasElapsed(trajectory.getTotalTimeSeconds());
  }
}
