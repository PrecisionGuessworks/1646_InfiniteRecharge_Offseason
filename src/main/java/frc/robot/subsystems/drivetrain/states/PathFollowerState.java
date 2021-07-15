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

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //hewwo :3 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return path_timer.hasElapsed(trajectory.getTotalTimeSeconds());
  }
}
