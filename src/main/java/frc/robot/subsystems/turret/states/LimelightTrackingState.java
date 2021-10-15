// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.turret.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Controllers;
import frc.robot.Constants.TurretConstants;
import frc.robot.subsystems.turret.TurretSubsystem;

public class LimelightTrackingState extends CommandBase {
  
  private TurretSubsystem turret = TurretSubsystem.getInstance();

  public LimelightTrackingState() {
    addRequirements(turret);
  }

  @Override
  public void execute() {
    double targetPosition;
     
    if (turret.isTargetSeenByLimeLight()){
      targetPosition = turret.getLimeLightTargetXPosInRadians();
    }else{
      targetPosition = Controllers.getOperatorController().getDirectionRadians();
    }

    turret.setPositionInRadians(targetPosition);
  }

  @Override
  public boolean isFinished() {
    return Math.abs(turret.getLimeLightTargetXPosInRadians()) < TurretConstants.TOLERANCE_IN_RADIANS;
  }
}
