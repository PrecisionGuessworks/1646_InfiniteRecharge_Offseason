// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ShootBalls;
import frc.robot.subsystems.drivetrain.states.DriveForwardState;


public class ShooterThenDrive extends SequentialCommandGroup {

  public ShooterThenDrive() {
    addCommands(
      new ShootBalls().withTimeout(7),
      new DriveForwardState(Constants.DrivetrainConstants.autoDriveTime)
    );
  }
}
