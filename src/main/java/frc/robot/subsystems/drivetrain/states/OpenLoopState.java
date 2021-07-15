/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.drivetrain.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controllers;
import frc.robot.subsystems.drivetrain.DrivetrainSubsystem;

public class OpenLoopState extends CommandBase {

  DrivetrainSubsystem drive = DrivetrainSubsystem.getInstance();

  public OpenLoopState() {
    addRequirements(drive);
  }

  @Override
  public void execute() {
    double throttle = Controllers.getDriverController().getRawAxis(7);
    double rotate = Controllers.getDriverController().getRawAxis(3);
    drive.arcadeDrive(throttle, rotate);
  }
}
