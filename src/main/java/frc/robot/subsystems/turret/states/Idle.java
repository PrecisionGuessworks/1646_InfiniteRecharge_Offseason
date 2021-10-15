// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.turret.states;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turret.TurretSubsystem;

public class Idle extends CommandBase {
  
  TurretSubsystem turret = TurretSubsystem.getInstance();

  public Idle() {
    addRequirements(turret);
  }

  @Override
  public void initialize() {
    turret.setPowerToZero();
  }
}
