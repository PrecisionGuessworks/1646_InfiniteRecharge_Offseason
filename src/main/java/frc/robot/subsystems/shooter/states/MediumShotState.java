// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.shooter.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class MediumShotState extends CommandBase {

  ShooterSubsystem shooter = ShooterSubsystem.getInstance();

  public MediumShotState() {
    addRequirements(shooter);
  }

  @Override
  public void initialize() {
    shooter.setPower(ShooterConstants.MEDIUM_SHOT_POWER);
  }
}
