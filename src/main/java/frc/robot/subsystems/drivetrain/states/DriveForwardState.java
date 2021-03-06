/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drivetrain.states;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;

public class DriveForwardState extends CommandBase {
  
  DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();
  double driveTime;
  Timer pathTimer;

  public DriveForwardState(double driveTime) {
    pathTimer = new Timer();
    this.driveTime = driveTime;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    pathTimer.reset();
    pathTimer.start();
    drive.arcadeDrive(Constants.DrivetrainConstants.autoDrivepower, 0.0);
  }

  @Override
  public void end(boolean interrupted) {
    drive.setPower(0.0, 0.0);
  }

  @Override
  public boolean isFinished() {
    return pathTimer.hasElapsed(driveTime);
  }
}
