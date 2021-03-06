// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.turret.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.turret.TurretSubsystem;

public class PositionState extends CommandBase {
  
  TurretSubsystem turret = TurretSubsystem.getInstance();
  double positionInRadians;

  public PositionState(double positionInRadians) {
    this.positionInRadians = positionInRadians;

    addRequirements(turret);
  }

  @Override
  public void initialize() {
    turret.setPosition(positionInRadians);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(turret.getTurretPositionRadians() - positionInRadians) < TurretConstants.TOLERANCE_IN_RADIANS;
  }
}
